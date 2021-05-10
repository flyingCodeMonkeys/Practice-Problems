package XOfAKind;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean hasGroupsSizeX(int[] deck){
        if(deck.length == 1){
            return false;
        }

        Map<Integer, Integer> numMap = new HashMap();
        for(int x: deck){
            numMap.put(x, numMap.getOrDefault(x, 0)+1);
        }

        int count = 0;
        Set<Integer> numbers = numMap.keySet();
        for(Integer num: numbers){
            count = (count == 0) ? numMap.get(num) : gcd(numMap.get(num), count);
        }
        return count >= 2;
    }

    public int gcd(int num1, int num2){
        return num1 == 0 ? num2 : gcd(num2 % num1, num1);
    }
}
