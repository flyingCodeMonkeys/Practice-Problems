package KthLargestInArray;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 2 potential solutions:
 *  1) Sort the nums array (or turn it into a stream and then sort it), and take the kth highest element
 *
 *  2) use a priority queue/heap and store just the k size elements then take the top
 */
public class Solution {

    //Sorting solution
    public static int findKthLargest(int[] nums, int k) {
        IntStream numStream = Arrays.stream(nums);
        return numStream.boxed().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()).get(k - 1);
    }

    public static int findKthLargestwHeap(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for(int num:nums){
            if(minHeap.size() < k){
                minHeap.offer(num);
            }
            else if(num > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args){
        int[] nums = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int n = 3;
        int nthLargest = findKthLargestwHeap(nums, n);
        System.out.println("The " + n + "th largest element is: " + nthLargest);
    }
}
