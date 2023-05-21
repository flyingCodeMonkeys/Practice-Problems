package WordBreak2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * Backtrack
     * find all possible break points and recursively call
     * the suffix of the original string. use a map to keep track of the previous result
     *
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dynamicRecurse(s, wordDict, new HashMap<>());
    }

    public List<String> dynamicRecurse(String s, List<String> wordDict, Map<String, List<String>> memo){

        if(memo.containsKey(s)){
            return memo.get(s);
        }
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0){
            return result;
        }

        int n = s.length();

        for(String word : wordDict){
            if(!s.startsWith(word)){
                continue;
            }
            int end = word.length();
            if(n == end){
                result.add(word);
            }
            else{
                List<String> sub = dynamicRecurse(s.substring(end), wordDict, memo);
                for(String item : sub){
                    item = word + " " + item;
                    result.add(item);
                }
            }
        }
        memo.put(s, result);
        return result;
    }
}
