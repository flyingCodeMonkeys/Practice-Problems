package NQueens;

import java.util.ArrayList;
import java.util.List;

//Implementation of NQueens problem
public class Solution {
    private boolean isValid(List<Integer> cols){
        int rowIndex = cols.size() - 1;

        for(int i = 0; i < rowIndex; i++) {
            //check diagonals & if same col
            int diff = Math.abs(cols.get(i) - cols.get(rowIndex));
            if(diff == rowIndex - i || diff == 0) {
                return false;
            }
        }
        return true;
    }

    public List<List<Integer>> nQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        solveNQueens(n, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void solveNQueens(int n, int row, List<Integer> cols, List<List<Integer>> result) {
        if(row == n) {
            result.add(new ArrayList<Integer>(cols));
        }
        else {
            for(int col = 0; col < n; col++) {
                cols.add(col);
                if(isValid(cols)) {
                    //Recurse for solution
                    solveNQueens(n, row + 1, cols, result);
                }
                //Backtrack and remove the choice
                cols.remove(cols.size() - 1);
            }
        }
    }
}
