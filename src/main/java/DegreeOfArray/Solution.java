package DegreeOfArray;

import java.util.HashMap;

public class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> numCount = new HashMap<>();
        HashMap<Integer, Integer> firstSeen = new HashMap<>();
        int degree = 0;
        int minLength = 0;
        int index = 0;

        for(int num: nums){
            firstSeen.putIfAbsent(num, index);
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
            if(degree < numCount.get(num)){
                degree = numCount.get(num);
                minLength = index - firstSeen.get(num) + 1;
            }
            else if(numCount.get(num) == degree) {
                minLength = Math.min(minLength, index - firstSeen.get(num));
            }
            index++;
        }
        return minLength;
    }
}
