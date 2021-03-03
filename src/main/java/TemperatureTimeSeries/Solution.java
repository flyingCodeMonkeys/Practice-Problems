package TemperatureTimeSeries;

import java.io.*;
import java.util.*;

/*

For a given number, how long has it been larger than
all previous numbers in temperature array?

Keep track running max
   if the current max is less than the currentNum, update max
   if the currentNum < currentMax,
      calculate the diff in index between the max - curentNum

 */

class Solution {
    public static int[] temperatureMax(int[] temperatures) {
        int[] maxTemp = new int[temperatures.length];
        int max = 0;
        int maxPointer = 0;

        for(int i = 0; i < temperatures.length; i++) {
            if(temperatures[i] >= max) {
                max = temperatures[i];
                maxTemp[i] = i + 1;
                maxPointer = i;
            }
            else {
                maxTemp[i] = 1;
                for(int j = i; j >= maxPointer; j--) {
                    if (temperatures[i] < temperatures[j]) {
                        maxTemp[i] = i - j;
                        break;
                    }
                }
            }
        }

        return maxTemp;
    }


    public static void main(String[] args) {
        int[] temperatures = new int[] {30,50,60,20,10,40,60,90};
        int[] transformed = temperatureMax(temperatures);
        for(int num: transformed) {
            System.out.print(num + ", ");
        }
    }
}


/*
Your previous Plain Text content is preserved below:

# Given a Timeseries that keeps information about Temperature readings for a city,
# return a Timeseries that tells you, for a given day,
# how long has its value been the largest running value.
#
#
#
# eg: For temperature readings       temperatures = [30,50,60,20,10,40,60,90],
# the transformed timeseries would be               [ 1, 2, 3, 1, 1, 3, 7, 8]

[1,1,1,1...]

maxTemp = [1,2,3]
maxPointer = 2
max = 50
previousLargerNumber = 0

Need some way to keep track of previous larger number

 */