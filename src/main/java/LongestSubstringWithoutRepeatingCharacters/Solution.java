package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * Go through each letter with a sliding window keeping track of the max length, last letter
     * Maybe use a set
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> visited = new HashSet();
        int maxLength = 0;
        int left = 0;
        int right = 0;

        return recurseLongestSubstring(s, visited, 0, left, right);
    }

    public int recurseLongestSubstring(String s, Set<Character> visited, int maxLength, int left, int right){

        if(right >= s.length()){
            return maxLength;
        }

        if(visited.add(s.charAt(right))){
            maxLength = Math.max((right - left + 1), maxLength);

            if(s.length() == 1){
                return maxLength;
            }
            else{
                return recurseLongestSubstring(s, visited, maxLength, left, right+1);
            }
        }
        else{
            if(s.charAt(left) != s.charAt(right)){
                visited.remove(s.substring(left));
                left++;
            }
            visited.remove(s.charAt(left));
            left++;
            visited.add(s.charAt(right));
            return recurseLongestSubstring(s, visited, maxLength, left, right+1);
            }

    }
}