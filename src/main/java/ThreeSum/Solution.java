package ThreeSum;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();

        for(int i = 0; i < nums.length; ++i) {
            if(dups.add(nums[i])) {
                for(int j = i + 1; j < nums.length; ++j) {
                    int comp = -nums[i] - nums[j];

                    if(seen.containsKey(comp) && seen.get(comp) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], comp);
                        Collections.sort(triplet);
                        result.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }
        }
        return new ArrayList<>(result);
    }

}
