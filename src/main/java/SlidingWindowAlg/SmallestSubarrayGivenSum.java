package SlidingWindowAlg;

public class SmallestSubarrayGivenSum {
    public static int smallestSubarray(int targetSum, int[] arr) {
        int minWindowSize = Integer.MAX_VALUE;
        int currentWindowSum = 0;
        int windowStart = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            currentWindowSum -= arr[windowStart];
            windowStart++;
        }
        return minWindowSize;
    }
}
