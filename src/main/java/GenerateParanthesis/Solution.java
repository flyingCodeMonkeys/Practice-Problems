package GenerateParanthesis;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //Backtrack
    //Constraints:
    // -Can not close unless we first have an open left paranth.
    // -Can only have n open & close paranth.
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        int open = 0;
        int close = 0;
        backtrack(result, "", open, close, n);
        return result;
    }
    private void backtrack(List<String> result, String current,
                           int open, int close, int n) {
        if(current.length() == n * 2) {
            result.add(current);
            return;
        }
        if(open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }
        if(close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }
}
