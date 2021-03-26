package FindDuplicateNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
//    public int findDuplicate(int[] nums) {
//        Set<Integer> foundSet = new HashSet<Integer>();
//        for(int n:nums) {
//            if(foundSet.contains(n))
//                return n;
//            else
//                foundSet.add(n);
//        }
//        return -1;
//    }
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]){
                return nums[i];
            }
        }
        return -1;
    }
}