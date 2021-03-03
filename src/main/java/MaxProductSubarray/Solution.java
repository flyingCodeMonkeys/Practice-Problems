package MaxProductSubarray;

public class Solution {

    public static int getMaxProduct(int[] nums){
        if(nums == null || nums.length == 0) {
            return 0;
        }
        else if (nums.length == 1) {
            return nums[0];
        }
        int temp;
        int result = 1;
        int maxP = Integer.MIN_VALUE;
        int minP = nums[0];

        for(int i = 0; i < nums.length; i++) {
            result *= nums[i];
            maxP = Math.max(maxP, result);

        }


        for(int i = 0; i < nums.length; i++) {
            temp = maxP;
            maxP = Math.max(
                    Math.max( maxP*nums[i], minP*nums[i]), nums[i]);
            minP = Math.min(Math.min(temp*nums[i], minP*nums[i]), nums[i]);
            result = Math.max(result, maxP);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = {2,3,-2,4};
        System.out.println(getMaxProduct(test));
    }
}
