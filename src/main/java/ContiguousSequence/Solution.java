package ContiguousSequence;

/**
 * 17.8
 * Given array of integers (both positive and negative). Find the contiguous
 * sequence with the largest sum. Return the sum.
 *
 * ie.
 * Input: [2, -8, 3, -2, 4, -10]
 * Output: 5
 *   because 3 + -2 + 4
 *
 */
public class Solution {

    public int getMaxSum(int[] arr) {
        int runningMax = Integer.MIN_VALUE;
        int arrSize = arr.length;
        int maxUpToCurrent = 0;

        for(int i = 0; i < arrSize; i++) {
            maxUpToCurrent = maxUpToCurrent + arr[i];
            runningMax = maxUpToCurrent == Integer.MIN_VALUE ? arr[i] : maxUpToCurrent + arr[i];
            maxUpToCurrent = maxUpToCurrent < 0 ? 0 : maxUpToCurrent;
        }

        return runningMax;
    }

}
