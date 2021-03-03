package LongestPalindromeSubstring;

public class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        //boolean dp[][] = new boolean[length][length];

        if(length <= 1){
            return s;
        }

        String longest = s.substring(0,1);

        for(int i = 0; i < length; i++) {
            String temp = palinString(s, i, i);
            String temp2 = palinString(s, i, i+1);
            temp = temp.length() > temp2.length() ? temp : temp2;
            if(temp.length() > longest.length()) {
                longest = temp;
            }
        }
        return longest;
    }

    public String palinString(String s, int start, int end) {
        while(start >= 0 && end <= s.length() - 1
        && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start+1, end);
    }
}
