package MinimumPathEffort;

import java.util.*;

public class Solution {
    int[][] ORIENTATION = {{0,1},{1,0},{-1,0},{0,-1}};

    public int minimumEffortPath(int[][] heights) {
        int maxDiff = 0;
        int rowLength = heights.length;
        int colLength = heights[0].length;
        int[][] weights = new int[rowLength][colLength];
        boolean[][] visited = new boolean[rowLength][colLength];
        for(int[] weight : weights){
            Arrays.fill(weight, Integer.MAX_VALUE);
        }
        weights[0][0] = 0;

        //Use min heap to store coordinate & the cost
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        heap.offer(new int[]{0,0,0});

        while(heap.size() > 0){
            int[] current = heap.poll();
            int x = current[0];
            int y = current[1];
            int weight = current[2];

            if((x == rowLength - 1) && (y == colLength - 1)){
                return weight;
            }
            visited[x][y] = true;

            for(int[] o : ORIENTATION){
                int x2 = x + o[0];
                int y2 = y + o[1];
                if(x2 < 0 || y2 < 0
                    || x2 >= rowLength
                    || y2 >= colLength
                    || visited[x2][y2]) continue;

                int nextWeight = Math.max(weight, Math.abs(heights[x][y] - heights[x2][y2]));
                if(weights[x2][y2] > nextWeight){
                    weights[x2][y2] = nextWeight;
                    heap.offer(new int[]{x2, y2, nextWeight});
                }
            }
        }

        return 0;
    }

}