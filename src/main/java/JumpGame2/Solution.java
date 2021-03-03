package JumpGame2;

public class Solution {
    public int jump(int[] nums) {
        //Check if 1 element- then just return 0 cause we already reached it
        if(nums.length <= 1)
            return 0;

        int count = 0;
        int reachable = 0;
        int position = 0;

        for(int i = 0; i < nums.length - 1; i++) {
            reachable = Math.max(reachable, nums[i] + i);
            if(position == i) {
                position = reachable;
                count ++;
            }
        }
        return count;
    }
}
