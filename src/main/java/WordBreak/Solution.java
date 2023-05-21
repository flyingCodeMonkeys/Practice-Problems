package WordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] visited = new boolean[n+1];
        //initialize first element in visited array to be true
        visited[0] = true;

        int maxLength = 0;
        for(String word : wordDict){
            maxLength = Math.max(maxLength, word.length());
        }

        for(int i = 0; i <= n; i++){

            //we can decrement j starting from the right. i - 1 position
            //saves time by not having to count values later to it
            for(int j = i - 1; j >= 0; j--){
                if(i - j > maxLength){
                    continue;
                }
                if(visited[j] && wordDict.contains(s.substring(j, i))){
                    visited[i] = true;
                    break;
                }
            }
        }
        //the last element will ultimately tell us if the string is able
        //to be broken
        return visited[n];
    }
}