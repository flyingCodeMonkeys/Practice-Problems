package TopKFrequentElements;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    //HashMap
    //O(nlogn)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int[] resArray = new int[k];

        for(int num: nums) {
            countMap.put(num, countMap.getOrDefault(num, 0)+1);
        }

        List<Integer> res = countMap.entrySet()
                .stream()
                .sorted((element1, element2) -> element2.getValue().compareTo(element1.getValue()))
                .limit(k)
                .map(e -> e.getKey())
                .collect(Collectors.toList());

        for(int i = 0; i < k; i++){
            resArray[i] = res.get(i);
        }

        return resArray;
    }

//    //Priority Queue
//    //O(n log k)
//    public int[] topKFrequent(int[] nums, int k) {
//        int[] resArray = new int[k];
//
//        return resArray;
//    }
}
