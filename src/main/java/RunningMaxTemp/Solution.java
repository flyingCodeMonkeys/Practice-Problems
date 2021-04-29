package RunningMaxTemp;

import java.util.Stack;

public class Solution {
    public static int[] temperatureMax(int[] temperatures){
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack(); //Indices of increasing temps
        for(int i = temperatures.length - 1; i >= 0; i--){
            //If the current temp is higher than the temp we have on stack, pop it off
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}
