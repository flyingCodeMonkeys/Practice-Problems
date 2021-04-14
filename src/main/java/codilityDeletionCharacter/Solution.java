package codilityDeletionCharacter;

import java.util.PriorityQueue;

public class Solution {
    public int solution(String s, int[] c) {
        int biggest = c[0];
        int total = 0;
        char letter;
        char[] strArray = s.toCharArray();

        for (int i = 1; i < strArray.length; i++) {
            // check for repeated character
            if (strArray[i - 1] == strArray[i]) {
                letter = strArray[i];
                total += c[i - 1];
                biggest = c[i - 1];
                while (i < strArray.length && strArray[i] == letter) {
                    total += c[i];
                    biggest = Math.max(biggest, c[i]);
                    i++;
                }
                // remove the biggest c from the total cost
                // keeping the most costly deletion
                total -= biggest;
            }
        }
        return total;
    }
}
