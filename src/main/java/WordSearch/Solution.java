package WordSearch;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static boolean exist(char[][] board, String word) {
        if(word == null ||
                board == null ||
                board.length == 0) {
            return false;
        }
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                return retreiveWord(row, col, board, word, 0);
            }
        }
        return false;
//        HashMap<Character, Set> adjList = new HashMap();
//        int rowSize = board.length;
//        int colSize = board[0].length;
//        for(int i = 0; i < rowSize; i++){
//            for(int j = 0; j < colSize; j++){
//                if(!adjList.containsKey(board[i][j])){
//                    Set<Character> values = new HashSet<Character>();
//                    int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
//                    for(int[] term : direction){
//                        int new_row = i+term[0];
//                        int new_col = j+term[1];
//                        if(new_row >= 0
//                                && new_col >= 0
//                                && new_col < colSize
//                                && new_row < rowSize) {
//                            values.add(board[new_row][new_col]);
//                        }
//                    }
//                    adjList.put(board[i][j], values);
//                }
//            }
//        }

        //return retrieveNextLetter(word, adjList, 0);
    }

    private static boolean retreiveWord(int row, int col, char[][] board, String word, int index) {
        if(index == word.length()){
            return true;
        }
        if(row < 0 ||
                col < 0 ||
                board.length <= row ||
                board[0].length <= col) {
            return false;
        }
        if(board[row][col] != word.charAt(index)) {
            return false;
        }

        boolean result = retreiveWord(row, col-1, board, word, index+1) ||
                retreiveWord(row-1, col, board, word, index+1) ||
                retreiveWord(row+1, col, board, word, index+1) ||
                retreiveWord(row, col+1, board, word, index+1);

        return result;
    }

//    private static boolean retrieveNextLetter(String word, HashMap<Character, Set> adjList, int index) {
//        if(index == word.length() && adjList.containsKey(word.charAt(index)))
//            return true;
//        else if(!adjList.get(word.charAt(index)).contains(adjList.get(word.charAt(index+1)))){
//            return false;
//        }
//        retrieveNextLetter(word, adjList, index+1);
//        return false;
//    }

    public static void main(String[] args) {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
        System.out.println(exist(board, "ABCCED"));
    }
}
