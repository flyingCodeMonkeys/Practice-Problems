package codilitySmallestPositiveInt;

public class Solution {
    public int solution(int[] A) {
        int len = A.length;
        boolean[] exists = new boolean[len+1];

        for(int i = 0; i < len; i++) {
            if(A[i] > 0 && A[i] <= len) {
                exists[A[i]] = true;
            }
        }

        for(int i = 0; i < len; i++) {
            if(!exists[i]) {
                return i;
            }
        }

        return len+1;
    }



//    private int separate(int array[], int length) {
//        int negatives = 0;
//        for(int index = 0; index < length; index++) {
//            if(array[index] <= 0) {
//                int temp = array[index];
//                array[index] = array[negatives];
//                array[negatives] = temp;
//                negatives++;
//            }
//        }
//        return negatives;
//    }
}
