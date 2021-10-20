package KnightDialer;

/**
 * Suppose F(1, N)
 * Think what are the ways to reach number 1 on keypad....
 * F(N, 1) = F(6, N-1) + F(7, N-1)...
 * F(N, 2) = F(6, N-1) + F(7, N-1)....
 * F(N, 3)...
 * F(N, 4)...
 *
 * F = the total number of distinct numbers that
 *     can be generated in N steps leading to the target digit
 * Final resulting solution = sum( F(0,N) + F(1,N) + F(2,N) ... F(9, N))
 *
 *  1 , 2 , 3
 *  4 , 5 , 6
 *  7 , 8 , 9
 *    , 0
 *
 *  N=1
 *  DP Table
 *     0  1  2  3  4  5  6  7  8  9
 *  0  0  0  0  0  0  0  0  0  0  0
 *  1  1  1  1  1  1  1  1  1  1  1
 *  2  2
 *  3
 *
 */

public class Solution {
    int mod = 10 * 9 + 7;
    //HashMap<Integer, int[]> paths = new HashMap<>();

    private static final int[][] paths = new int[][] {
            {4, 6}, {6, 8}, {7, 9}, {4, 8},
            {3, 9, 0}, {}, {1, 7, 0},
            {2, 6}, {1, 3}, {2, 4}
    };
    int dp[][];
    public int knightDialer(int n) {
        dp = new int[10][n];

        long[] waysToDigit = new long[]{1,1,1,1,1,1,1,1,1,1};

        for(int i = 0; i < n - 1; ++i){
            long[] temp = new long[10];

            for(int j = 0; j < 10; j++){

                //What digits can we get to?
                for(int path : paths[j]){
                    temp[j] = (temp[j] + waysToDigit[j]) % mod;
                }
            }
            waysToDigit = temp;
        }

        long result = 0;
        for(long origin : waysToDigit){
            result = (result + origin) % mod;
        }
        return (int) result;
    }
}
