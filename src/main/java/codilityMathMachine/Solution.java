package codilityMathMachine;

import java.util.Stack;

public class Solution {
    private Stack<Integer> stack = new Stack();

    public int solution(String s) {
        String[] instructions = s.split(" ");
        int res = -1;

        for(int i = 0; i < instructions.length; i++) {
            try {
                int num = Integer.parseInt(instructions[i]);
                stack.push(num);
            }
            catch (NumberFormatException e){
                //Parse the instructions if it is not an integer

                if(instructions[i].equals("POP")){
                    stack.pop();
                    res = stack.peek();
                }
                else if(instructions[i].equals("DUP")){
                    //System.out.println("in dup:"+stack.peek());
                    stack.push(stack.peek());
                    //System.out.println("after pushing- new size: "+stack.size());
                    res = stack.peek();
                }
                else if((stack.size() > 2) && (instructions[i].equals("+")
                        || instructions[i].equals("-"))
                        && (!instructions[i-1].equals("+"))){
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    res = doMathOp(num1, num2, instructions[i]);
                }
            }
        }
        return res;
    }

    private int doMathOp(int num1, int num2, String i) {
        int res = -1;
        if(i.equals("+") && (num1 + num2 < Math.pow(2, 20)-1)){
            res = num1 + num2;
            stack.push(res);
        }
        else if(i.equals("-") && (num1 - num2 > 0)){
            res = num1 - num2;
            stack.push(res);
        }
        return res;
    }

    public static void main(String[] args){
        String text = "13 DUP 4 POP 5 DUP + DUP + -";
        Solution s = new Solution();
        int res = s.solution(text);
    }
}
