package WordSearch2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;

        List<String> result = new ArrayList<>();
        boolean findNextWord = true;

        for(int i = 0; i < words.length &&
                words[i].length() <= m * n; i++) {
            for(int j = 0; j < m && findNextWord; j++){

            }
        }
        return result;
    }
}
