package TrappingRainWater;

//Similar to the max water container problem
public class Solution {
    public int trap(int[] height) {
            int[] leftHeight = new int[height.length];
            int[] rightHeight = new int[height.length];

            int[] waterContained = new int[height.length];
            int leftMaxHeight = Integer.MIN_VALUE;
            int rightMaxHeight = Integer.MIN_VALUE;

            for(int i=1; i < height.length; i++) {
                if(leftMaxHeight < height[i-1]) {
                    leftMaxHeight = height[i-1];
                }
                leftHeight[i] = leftMaxHeight;
            }

            for(int i=height.length-1; i > 0; i--) {
                if(rightMaxHeight < height[i]) {
                    rightMaxHeight = height[i];
                }
                rightHeight[i] = rightMaxHeight;
            }

            for(int i = 1; i < height.length; i++) {
                int area = Math.min(leftHeight[i], rightHeight[i]) - height[i];
                waterContained[i] = area > 0 ? area : 0;
            }

            int sum = 0;
            for(int i = 0; i < height.length; i++) {
                sum += waterContained[i];
            }

            return sum;
    }


}
