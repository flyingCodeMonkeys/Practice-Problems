package RottingOranges;

import java.util.*;

/**
 * BFS traversal
 * Add oranges to initial set of fresh oranges and rotten oranges
 * traverse the set of fresh oranges
 */

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int freshOranges = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;

        Set<String> visited = new HashSet<>();

        for(int r = 0; r < rowLength; r++) {
            for(int c = 0; c < colLength; c++) {
                if(grid[r][c] == 2){
                    queue.offer(new int[]{r,c});
                    visited.add(r+","+c);
                }
                else if(grid[r][c] == 1){
                    freshOranges++;
                }
            }
        }


        //BFS Traversal- increment minutes every level we traverse
        int minutes = 0;
        int[][] direction = {{-1,0},{0,1},{1,0},{0,-1}};

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] current = queue.remove();
                for(int[] dir: direction){
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];
                    if(x < 0 || y < 0 || x >= rowLength
                            || y >= colLength || visited.contains(x + "," + y)
                            || grid[x][y] != 1){
                        continue;
                    }
                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                    visited.add(x+","+y);
                }
                if(queue.size() > 0){
                    minutes++;
                }
            }
        }
        for(int i = 0; i < rowLength; i++) {
            for(int j = 0; j < colLength; j++){
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return minutes;
    }
}
