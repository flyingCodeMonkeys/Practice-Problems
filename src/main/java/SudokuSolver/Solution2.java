package SudokuSolver;

public class Solution2 {
    char[][] board;
    int N;
    final int EMPTY = '.';

    public void solveSudoku(char[][] board){
        /**
         * Recursively call the backtrack method to place numbers
         * till have solution
         */
        this.board = board;
        this.N = board.length;
//        for(int i = 0; i < board.length; i++)
//        {
//            for(int j = 0; j < board[0].length; j++)
//            {
//                if(board[i][j] == '\0')
//                {
//                    board[i][j] = '.';
//                }
//            }
//        }

        solveBackTrack(board);
    }

    private boolean solveBackTrack(char[][] board) {
        int r = N;
        int c = N;
//        int next_row = row;
//        int next_col = col;

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(board[i][j] == EMPTY){
                    for(int num = 1; num < N; num ++){

                        if(isValid(i, j, (char)num)){
                            board[i][j] = (char)num;
                            if(solveBackTrack(board)){
                                return true;
                            }
                        }
                         board[i][j] = EMPTY;
                        }
                    }
                }
            }
        return false;
    }

    private boolean validRow(int row, int val){
        for(int i = 0; i < N; i++){
            if(board[row][i] == val){
                return false;
            }
        }
        return true;
    }

    private boolean validCol(int col, int val) {
        for(int i = 0; i < N; i++){
            if(board[i][col] == val){
                return false;
            }
        }
        return true;
    }

    private boolean validBox(int row, int col, int val) {
        int r = row - row % 3;
        int c = col - col % 3;

        for(int i = r; i < r + 3; i++){
            for(int j = c; j < c + 3; j++){
                if(board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int row, int col, int val){
        return validRow(row, val) && validCol(col, val)
                && validBox(row, col, val);
    }
}
