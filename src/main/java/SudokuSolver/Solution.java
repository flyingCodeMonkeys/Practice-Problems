package SudokuSolver;

import java.util.stream.IntStream;

public class Solution {
    private int NO_VAL = 0;
    private int MIN_VAL = 1;
    private int MAX_VAL = 9;
    private int BOARD_LEN = 0;
    private int SECTION_SIZE = 3;
    private boolean solve(int[][] board) {
        BOARD_LEN = board.length;
        for(int row = 0; row < BOARD_LEN; row++) {
            for(int col = 0; col < BOARD_LEN; col++) {
                if(board[row][col] == NO_VAL) {
                    for(int k = MIN_VAL; k < MAX_VAL; k++) {
                        board[row][col] = k;
                        if(isValid(board, row, col) && solve(board)) {
                            return true;
                        }
                        board[row][col] = NO_VAL;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int[][] board, int row, int col) {
        return (rowConstraint(board, row)) && colConstraint(board, col)
                && subsectionConstraint(board, row, col);
    }

    private boolean subsectionConstraint(int[][] board, int row, int col) {
        boolean[] constraint = new boolean[BOARD_LEN];
        int subsectionRowStart = row;
        int subsectionRowEnd = subsectionRowStart + SECTION_SIZE;

        int subsectionColStart = col;
        int subsectionColEnd = subsectionColStart + SECTION_SIZE;

        //Iterate through each subsection and check if it is in the
        //constraints
        for(int r = subsectionRowStart; r < subsectionRowEnd; r++){
            for(int c = subsectionColStart; c < subsectionColEnd; c++){
                if(!checkConstraint(board, r, constraint, c))
                    return false;
            }
        }
        return true;
    }

    private boolean rowConstraint(int[][] board, int row) {
        boolean[] constraint = new boolean[BOARD_LEN];
        return IntStream.range(0, BOARD_LEN)
                .allMatch(col -> checkConstraint(board, row, constraint, col));
    }

    private boolean colConstraint(int[][] board, int col) {
        boolean[] constraint = new boolean[BOARD_LEN];
        return IntStream.range(0, BOARD_LEN)
                .allMatch(row -> checkConstraint(board, row, constraint, col));
    }
    
    private boolean checkConstraint(int[][] board, int row, boolean[] constraint, int col) {
        if(board[row][col] != NO_VAL) {
            if(constraint[board[row][col] - 1] == false) {
                constraint[board[row][col] - 1] = true;
            }
            else {
                return false;
            }
        }
        return true;
    }

    private void displayBoard(int[][] board) {
        for(int row = 0; row < BOARD_LEN; row++) {
            for(int col = 0; col < BOARD_LEN; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] board1 = {
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 4, 0, 0}
        };
        s.solve(board1);
        s.displayBoard(board1);
    }
}


