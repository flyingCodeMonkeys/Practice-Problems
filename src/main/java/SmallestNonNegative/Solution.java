package SmallestNonNegative;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int smallestNumber(int[] nums){
        if(nums.length < 1 || nums == null) {
            return 1;
        }

        Set<Integer> minSet = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0 && nums[i] <= nums.length) {
                minSet.add(nums[i]);
            }
        }

        for(int j = 1; j < nums.length + 1; j++) {
            if(!minSet.contains(j)) {
                return j;
            }
        }

        return nums.length + 1;
    }

    public static void main(String[] args){
        int[] test = {1};
        System.out.println(smallestNumber(test));
    }
}
