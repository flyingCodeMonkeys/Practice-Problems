package MedianSortedArrays;

//Median is the element that partitions the arrays in half
public class Solution {

    public double findMedianSortedArrays(int[] A, int[] B) {
        int x = A.length;
        int y = B.length;
        if(x < y) {
            int[] tmp = A;
            A = B;
            B = tmp;
            int z = x;
            x = y;
            y = z;
        }

        int iMin = 0;
        int iMax = x;
        int half = (x + y + 1) / 2;


//        while(iMin )
//
//        int low = 0;
//        int high = x - 1;
//
//        for(int i = 0; i < B.length; i++) {
//            if(A[high] <)
//        }
//
//        return 0;
    }

    private double medSortedHelper(int[] firstArr, int firstLeft, int firstRight, int[] secArr) {
        int firstMid = (firstRight + firstLeft) / 2;
        int secMid = (secArr.length - 1)/2 - firstMid + (firstArr.length - 1) / 2;

        double median = 0;

        if(firstRight - firstLeft <= 1) {
            int[] temp;
        }
        return median;
    }

    private double median(int[] Arr) {
        int l = Arr.length;
        return (Arr.length % 2 == 0) ? Arr[(l - 1 )/ 2] : (Arr[(l - 1)/2] + Arr[(l - 1)/2 + 1])/2;
    }

}
