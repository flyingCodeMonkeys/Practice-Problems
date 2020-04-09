package SpiralNumbers;

/*

Given an integer N, output an N x N spiral matrix with integers 1 through N2.
Examples:

Input:  3

Output: [[1, 2, 3],
         [8, 9, 4],
         [7, 6, 5]

Input: 1

Output: [[1]]
order matters- make the numbers spiral clockwise around the NxN matrix

*/

public class Solution {

    public static int[][] makeSpiralMatrix(int n) {
        int[][] matrix = new int[n][n];
        int minRow = 0;
        int minCol = 0;
        int maxRow = n - 1;
        int maxCol = n - 1;
        int counter = 1;

      while(minRow < maxRow && minCol < maxCol) {
          //going across top row
          for(int i = minCol; i <= maxCol; i++) {
              matrix[minRow][i] = counter;
              counter++;
          }
          minRow++;

          //Going down the maxCol
          for(int i = minRow; i <= maxRow; i++) {
              matrix[i][maxCol] = counter;
              counter++;
          }
          maxCol--;

          //Going Right to left on bottom row
          for(int i = maxCol; i >= minCol; i--) {
              matrix[maxRow][i] = counter;
              counter++;
          }
          maxRow--;

          //Going up the minCol
          for(int i = maxRow; i >= minRow; i--) {
              matrix[i][minCol] = counter;
              counter++;
          }
          minCol++;
      }
      return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = makeSpiralMatrix(6);
        for(int[] row:matrix){
            for(int num:row){
                System.out.print(num+", ");
            }
            System.out.print("\n");
        }
    }

}
