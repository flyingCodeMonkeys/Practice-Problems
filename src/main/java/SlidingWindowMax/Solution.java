package SlidingWindowMax;

import java.util.Collections;
import java.util.PriorityQueue;
//Using a MaxHeap
public class Solution {
    class MaxWindow implements Comparable<MaxWindow>{
        int start;
        int val;

        MaxWindow(int val, int start) {
            this.val = val;
            this.start = start;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        @Override
        public int compareTo(MaxWindow maxWindow) {
            if(this.val > maxWindow.val){
                return 1;
            }
            else if(this.val < maxWindow.val){
                return -1;
            }
            return 0;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<MaxWindow> maxHeap = new PriorityQueue(Collections.reverseOrder());
        int[] max = new int[nums.length - k + 1];
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            maxHeap.add(new MaxWindow(nums[i], i));
            if(maxHeap.size() > k - 1) {
                while(maxHeap.peek().getStart() < (i-k+1)){
                    maxHeap.poll();
                }
                max[count++] = maxHeap.peek().getVal();
            }
        }
        return max;
    }
}