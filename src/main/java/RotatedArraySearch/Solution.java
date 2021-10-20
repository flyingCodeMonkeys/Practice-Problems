package RotatedArraySearch;

/**
 * Do a binary search to locate pivot
 * and do a binary search on one of the halves - narrowing down the target
 */

class Solution {
  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    if (nums.length == 1) {
      return nums[0] == target ? 0 : -1;
    }

    int left = 0;
    int right = nums.length - 1;
    int mid = 0;

    while (left < right) {
      mid = left + (right - left) / 2;
      if (nums[mid] >= nums[right]) {
        left = mid + 1;
      }
      else {
        right = mid;
      }
    }

    int start = left;
    left = 0;
    right = nums.length - 1;

    if (target >= nums[start] && target <= nums[right]) {
      left = start;
    }
    else {
      right = start;
    }

    while(left <= right) {
      mid = left + (right- left) / 2;
      if(nums[mid] == target){
        return mid;
      }
      else if(nums[mid] < target) {
        left = mid + 1;
      }
      else {
        right = mid - 1;
      }
    }
    return -1;
  }

}