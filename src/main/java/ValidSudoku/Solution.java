package ValidSudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*
        Iterate through every row & column
        add the numbers to a Set visited if its not there
        if it is there, then return FALSE

        at the end, if we can add all numbers to our set, return TRUE

        1 in row 3

        row
            col


            visited.add(1 in row/3 and col/3)
                return false

        */
        Set visited = new HashSet();

        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                char number = board[row][col];

                if(number != '.'){

                    if(!visited.add(number + " row " + row) ||
                            !visited.add(number + " col " + col) ||
                            !visited.add(number + " grid " + row/3 + ","+ col/3))
                        return false;

                }
            }
        }
        return true;
    }
}
