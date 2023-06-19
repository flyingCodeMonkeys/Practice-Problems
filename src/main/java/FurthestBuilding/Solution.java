package FurthestBuilding;

import java.util.PriorityQueue;

public class Solution {

    /**
     * Use a heap to store the k height differences
     * Iterate through the heights:
     *  if height difference heights[i] - heights[i+1] > 0:
     *      push diff onto heap
 *
     *  if the size of heap > # of ladders, have to use brick
     *
     *  if bricks is not enough, then return i- our current iteration
     *  if we make it to the end, we can return the size of heights array - 1
 *
     * @param heights
     * @param bricks
     * @param ladders
     * @return
     */

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int i = 0; i < heights.length - 1; i++){
            int current = heights[i];
            int next_height = heights[i+1];
            int diff = next_height - current;

            if(diff > 0){
                heap.add(diff);
            }
            if(heap.size() > ladders)
                bricks -= heap.poll();

            if(bricks < 0){
                return i;
            }
        }
        return heights.length - 1;

    }
}
