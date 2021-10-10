package KnightProbabilityChessboard;

public class Solution {
    int[][] directions = {{-1, 2}, {-1, -2}, {1, 2},{2, 1},
            {-2, 1}, {-2, -1}, {2, -1}, {1, -2}};
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k+1];

        return dfs(n, k, row, column, dp);

    }
    double dfs(int n, int k, int row, int column, double[][][]dp){
        if(k == 0) return 1;
        else if(dp[row][column][k] > 0) return dp[row][column][k];

        for(int[] dir: directions) {
            int newRow = row + dir[0];
            int newCol = column + dir[1];
            if(newRow < 0 || newCol < 0 ||
                newRow >= n || newCol >= n) continue;
            dp[row][column][k] += dfs(n, k - 1, newRow, newCol, dp) / 8;
        }
        return dp[row][column][k];
    }
}
