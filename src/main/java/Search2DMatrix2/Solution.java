package Search2DMatrix2;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target){
        for(int i = 0, j = matrix[0].length-1; i < matrix.length && j >= 0;){
            if(matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j] > target){
                j--;
            }
            else {
                i++;
            }
        }
        return false;
    }
}
