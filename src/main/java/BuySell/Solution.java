package BuySell;

import java.util.Arrays;

public class Solution {
//    Too slow! so.... Do Dynamic Programming - can cache results
//    public int maxProfit(int k, int[] prices) {
//        if(prices.length > 0) {
//            int[] profits = new int[prices.length];
//
//            for(int i = 0; i < profits.length; i++){
//                profits[i] = 0;
//            }
//
//            for(int j = 0; j < k; j++) {
//                //Min is the first item of array - as move through
//                //array, make those as min
//                int min = prices[0];
//                int max = 0;
//
//                for(int g = 1; g < prices.length; g++) {
//                    min = Math.min(min, prices[g] - profits[g]);
//                    max = Math.max(max, prices[g] - min);
//                    //Biggest profit will be either max or
//                    // diff of where we are at - min
//                    profits[g] = max;
//                }
//            }
//
//            return profits[profits.length - 1];
//        }
//        return 0;
//    }

    public int maxProfit(int k, int[] prices) {
        if(prices.length > 1) {
            int[] profits = new int[prices.length];
            Arrays.fill(profits, 0);
            int maxProfit = 0;
            if(prices.length / 2 > k) {
                for(int i = 1; i < prices.length; i++) {
                    maxProfit += Math.max(0, prices[i] - prices[i-1]);
                }
                return maxProfit;
            }

            int[][] dp = new int[k+1][prices.length];
            for(int i = 1; i <= k; i++) {
                int max = prices[0];

                for(int j = 1; j < prices.length; j++) {

                }
            }

            for(int j = 0; j < k; j++) {
                //Min is the first item of array - as move through
                //array, make those as min
                int min = prices[0];
                int max = 0;

                for(int g = 1; g < prices.length; g++) {
                    min = Math.min(min, prices[g] - profits[g]);
                    max = Math.max(max, prices[g] - min);
                    //Biggest profit will be either max or
                    // diff of where we are at - min
                    profits[g] = max;
                }
            }

            return profits[profits.length - 1];
        }
        return 0;
    }
}

/**
 function buyStock(arr, k){
 let profit = []
 for(let i = 0; i < arr.length; i++){
 profit.push(0)
 }
 for(let i = 0; i < k; i++){
 let min = arr[0]
 let max = 0

 for(let j = 1; j < arr.length; j++ ){
 min = Math.min(min, arr[j]-profit[j]) //===
 max = Math.max(max, arr[j]- min)
 profit[j] = max

 }
 }

 return profit.pop()
 }
 console.log(buyStock([0,3,1,5], 2))

 **/