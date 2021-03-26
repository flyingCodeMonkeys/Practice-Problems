package DailyTemperatures;

import java.util.Stack;

public class Solution {
    //Use stack to store values
    public int[] dailyTemperatures(int[] T) {
        int[] answer = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
            answer[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return answer;
    }
}
