 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

 Example:

 board =
 [
   ['A','B','C','E'],
   ['S','F','C','S'],
   ['A','D','E','E']
 ]

 Given word = "ABCCED", return true.
 Given word = "SEE", return true.
 Given word = "ABCB", return false.

{A:[B, S, D],
 B: [A, F, C]}
~O(n)


 Constraints:

 board and word consists only of lowercase and uppercase English letters.
 1 <= board.length <= 200
 1 <= board[i].length <= 200
 1 <= word.length <= 10^3
 direction = [(1,0),(0,1),(-1,0),(0,-1)]
 for d in directions:
       new_row,new_col = row+d[0],col+d[1]
       if 0<=new_row<rowSize and 0<=new_col<colSize:
          


      
      
      
