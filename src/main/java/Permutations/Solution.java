package Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */

public class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        generatePermutations(nums, 0, current, result);
        return result;
    }

    private static void generatePermutations(int[] nums, int index, List<Integer> current,
                                      List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i <= current.size(); i++) {
            List<Integer> permutation = new ArrayList<>(current);
            permutation.add(i, nums[index]);
            generatePermutations(nums, index + 1, permutation, result);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1,4,7,2,3,88,5};
        int[] arr2 = {2,7,5,3};

        List<List<Integer>> res1 = permute(arr1);
        List<List<Integer>> res2 = permute(arr2);
        System.out.println(res1);
        System.out.println(res2);
    }
}
