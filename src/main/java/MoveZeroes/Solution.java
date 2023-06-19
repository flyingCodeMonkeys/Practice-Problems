package MoveZeroes;

public class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZeroPtr = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[lastNonZeroPtr++] = nums[i];
            }
        }

        for(int j = lastNonZeroPtr; j < nums.length; j++){
            nums[j] = 0;
        }
    }
}