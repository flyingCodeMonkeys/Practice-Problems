package AtlanticPacificProblem;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //Using DFS
    public List<List<Integer>> pacificAtlantic(int[][] matrix){
        if(matrix.length == 0 || matrix[0].length == 0) return new ArrayList();

        List<List<Integer>> result = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            find(matrix, i, 0, Integer.MIN_VALUE, pacific);
            find(matrix,  i, n-1, Integer.MIN_VALUE, atlantic);
        }

        for(int i = 0; i < n; i++) {
            find(matrix, 0, i, 0, pacific);
            find(matrix, m-1, i, 0, atlantic);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }
        return result;
    }

    private void find(int[][] matrix, int i, int j, int height, boolean[][] visited) {
        if(i < 0 || i >= matrix.length
            || j >= matrix[0].length || j < 0
            || visited[i][j] == true || matrix[i][j] < height) {
            return;
        }

        visited[i][j] = true;
        find(matrix, i+1, j, matrix[i][j], visited);
        find(matrix, i-1, j, matrix[i][j], visited);
        find(matrix, i, j+1, matrix[i][j], visited);
        find(matrix, i, j-1, matrix[i][j], visited);
    }

}
