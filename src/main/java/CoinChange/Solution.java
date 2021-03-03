package CoinChange;

import java.util.Arrays;

public class Solution {

    public static void main (String[] args) {
        System.out.println(coinchange(new int[] {1,2,4},20));
    }
    public static int coinchange (int[] coins, int target) {
        int[] amounts = new int[target + 1];
        Arrays.fill(amounts, Integer.MAX_VALUE);
        amounts[0] = 0;
        for (int a = 1; a <= target; a++) {
            for (int coin : coins) {
                int notused = amounts[a];
                if (coin <= a) {
                    amounts[a] = Math.min(amounts[a - coin] + 1, notused);
                }
            }
        }
        return amounts[target];
    }

}
