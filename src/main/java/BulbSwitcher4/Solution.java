package BulbSwitcher4;

public class Solution {
    public int minFlips(String target) {
        int count = 0;
        int size = target.length();
        int flippedNum = 0;

        for(int i=0; i < size; i++){
            if(flippedNum != (target.charAt(i) - '0')) {
                flippedNum = flippedNum == 0 ? 1 : 0;
                count++;
            }

        }
        return count;
    }
}