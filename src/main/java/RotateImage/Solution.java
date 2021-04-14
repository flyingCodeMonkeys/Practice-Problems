package RotateImage;

public class Solution {
    /**
     * Transpose matrix then loop
     *  Change the order of the columns- flip them horizontally
     */
    public void rotate(int[][] matrix) {
        int length = matrix.length;

        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        //Flip horizontally- swap columns
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length/2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][length - 1 - j];
                matrix[i][length - 1 - j] = tmp;
            }
        }

    }
}
