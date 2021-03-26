package MedianSortedArrays;

//Median is the element that partitions the arrays in half
//Calculate the median of both arrays & discard half of each array

/**
 *
 */
public class Solution {

    public double findMedianSortedArrays(int[] A, int[] B) {

//        int x = A.length;
//        int y = B.length;
//        int length = x + y;
//        if(x < y) {
//            int[] tmp = A;
//            A = B;
//            B = tmp;
//            int z = x;
//            x = y;
//            y = z;
//        }
//
//        int iMin = 0;
//        int iMax = x;
//        int half = (x + y + 1) / 2;
//        int[] result = new int[half];
//        int minidx = 0;
//        int maxidx = n;
//        int i = 0, j = 0;

        int x = A.length;
        int y = B.length;
        int totalLength = x + y;

        if(x > y) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        int low = 0;
        int max = A.length;
        while(low <= max) {
            int partition1 = (low + max) / 2;
            int partition2 = (totalLength + 1) / 2 - partition1;

            int leftHalf1  = getMax(A, partition1);
            int rightHalf1 = getMin(A, partition1);

            int leftHalf2  = getMax(B, partition2);
            int rightHalf2 = getMin(B, partition2);

            if(leftHalf1 <= rightHalf2 && leftHalf2 <= rightHalf1){
                if(totalLength % 2 == 0){
                    return (Math.max(leftHalf1, leftHalf2) + Math.min(rightHalf1, rightHalf2)) / 2.0;
                }
                return Math.max(leftHalf1, leftHalf2);
            }
            if(leftHalf1 > rightHalf2) {
                max = partition1 - 1;
            }
            else {
                low = partition1 - 1;
            }
        }
        return -1;
    }

    private int getMin(int[] array, int partition) {
        if(partition == array.length) {
            return (int)Double.POSITIVE_INFINITY;
        }
        else {
            return array[partition];
        }
    }

    private int getMax(int[] array, int partition) {
        if(partition == array.length) {
            return (int)Double.POSITIVE_INFINITY;
        }
        else {
            return array[partition - 1];
        }
    }

}
