package SlidingWindowMax;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k){
        Deque<Integer> dq = new LinkedList();
        int[] ans = new int[nums.length - k + 1];
        int ansIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(i >= k){
                while(!dq.isEmpty() && dq.peek() <= i - k){
                    dq.poll();
                }
            }
            while(!dq.isEmpty() && (nums[i] > nums[dq.peekLast()])){
                dq.pollLast();
            }
            dq.offer(i);
            if(i >= k - 1){
                ans[ansIndex++] = nums[dq.peek()];
            }
        }
        return ans;
    }
}
