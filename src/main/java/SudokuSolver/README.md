https://leetcode.com/problems/sudoku-solver/

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

1. Each of the digits 1-9 must occur exactly once in each row.
2. Each of the digits 1-9 must occur exactly once in each column.
3. Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
   The '.' character indicates empty cells.

EXAMPLE 1

Input1 : board = [<br/>["5","3",".",".","7",".",".",".","."],<br/>["6",".",".","1","9","5",".",".","."],<br/>[".","9","8",".",".",".",".","6","."],<br/>["8",".",".",".","6",".",".",".","3"],<br/>["4",".",".","8",".","3",".",".","1"],<br/>["7",".",".",".","2",".",".",".","6"],<br/>[".","6",".",".",".",".","2","8","."],<br/>[".",".",".","4","1","9",".",".","5"],<br/>[".",".",".",".","8",".",".","7","9"]]

Output1 : [<br/>["5","3","4","6","7","8","9","1","2"],<br/>["6","7","2","1","9","5","3","4","8"],<br/>["1","9","8","3","4","2","5","6","7"],<br/>["8","5","9","7","6","1","4","2","3"],<br/>["4","2","6","8","5","3","7","9","1"],<br/>["7","1","3","9","2","4","8","5","6"],<br/>["9","6","1","5","3","7","2","8","4"],<br/>["2","8","7","4","1","9","6","3","5"],<br/>["3","4","5","2","8","6","1","7","9"]]
<br/>Explanation1:

Explanation: The only valid solution for the input board is this output board.


Constraints:
- board.length == 9
- board[i].length == 9
- board[i][j] is a digit or '.'.
- It is guaranteed that the input board has only one solution.
