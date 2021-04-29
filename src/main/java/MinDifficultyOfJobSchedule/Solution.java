package MinDifficultyOfJobSchedule;

import java.util.Arrays;

/**
 * Dynamic Programming
 *        i
 * difficulty: [3,2,4,5,6,1] must finish all jobs before i inorder to do i
 *
 */
public class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        if(d > n) return -1;

        int[][] dp = new int[d + 1][n];
        int maxAll = 0;
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
//
//        for(int i = 1; i < n; i++){
//            for(int j = i; j < n; j++) {
//                int min = dp[i - 1][j - 1] + jobDifficulty[j];
//                int max = jobDifficulty[j];
//                for(int k = j; k >= i; k--){
//                    max = Math.max(max, jobDifficulty[k]);
//                    min = Math.min(min, dp[i - 1][k - 1] + max);
//                }
//
//                dp[i][j] = min;
//            }
//        }
//        return dp[d - 1][n - 1];
        return dfs(jobDifficulty, d, dp, 0);
    }

    private int dfs(int[] jobDifficulty, int d, int[][] dp, int index){
        int max = 0;
        if(d == 1){
            while(index < jobDifficulty.length){
                max = Math.max(max, jobDifficulty[index++]);
            }
            return max;
        }
        if(dp[d][index] != -1) {
            return dp[d][index];
        }
        max = 0;
        int res = Integer.MAX_VALUE;
        for(int i = index; i < jobDifficulty.length - d + 1; i++){
            max = Math.max(max, jobDifficulty[i]);
            res = Math.min(res, max + dfs(jobDifficulty, d - 1, dp, i + 1));
        }
        return dp[d][index] = res;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] jobsList = {1,2,3,4,6};
        System.out.println(s.minDifficulty(jobsList,2));
    }
}
