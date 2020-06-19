package ContainerMostWater;

//O(n)
public class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int len = height.length;
        int left = 0;
        int right = len - 1;

        while(left < right) {
            int h = 0;
            int temp = 0;

            if(height[left] < height[right]) {
                h = height[left];
                temp = (right - left) * h;
                left++;
            }
            else {
                h = height[right];
                temp = (right - left) * h;
                right--;
            }
            area = Math.max(area, temp);
        }
        return area;
    }
}
