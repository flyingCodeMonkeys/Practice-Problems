package codilityArraySum;

import java.util.HashMap;

public class Solution {
    public int solution(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = 200000;
        int result = -1;
        for(int i = 0; i < n; i++) {
            map.put(i, 0);
        }
        for(int i = 0; i < A.length; i++) {
            int num = A[i];
            int sum = 0;
            for(int j = num; num > 0; num /= 10){
                sum +=(num % 10);
            }

            if(map.get(sum) != 0) {
                result = Math.max(result, map.get(sum) + A[i]);
            }
        }
        return result;
    }

}
