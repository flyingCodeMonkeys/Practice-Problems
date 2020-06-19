package CoupleHoldingHands;

public class Solution {
    public int minSwapsCouples(int[] row) {
        int minSwap = 0;

        for(int i = 0; i < row.length; i = i + 2) {
            int j;
            if(row[i] % 2 == 0) {
                j = find(row, row[i] + 1, i + 1);
            }
            else {
                j = find(row, row[i] - 1, i - 1);
            }

            if((i + 1) != j) {
                int temp = row[i + 1];
                row[i + 1] = row[j];
                row[j] = temp;
            }
        }

        return minSwap;
    }
    private int find(int[] row, int k, int start) {
        for(int i = start; i < row.length; i++) {
            if(row[i] == k) {
                return i;
            }
        }
        return -1;
    }
}
