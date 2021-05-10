package ExpressionAddOperators;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    char[] nums;
    public List<String> addOperators(String num, int target){
        List<String> res = new ArrayList<String>();
        nums = num.toCharArray();
        int length = nums.length;
        char[] chars = new char[length * 2];
        int numPtr = 0;
        int chPtr = 0;
        long value = 0;

        for(int i = 0; i < length; i++){
            value = value * 10 + nums[numPtr] - '0';
            chars[chPtr++] = nums[i];

            res = helper(i + 1, chPtr, 0, value,
                    length, chars, res, target);
            if(value == 0) break;

        }
        return res;
    }

    private List<String> helper(int numPtr, int chsPtr, long cur, long prev,
                        int length, char[] chs, List<String> res,
                        int target){
        if(numPtr == length){
            if(cur + prev == target){
                res.add(new String(chs, 0, chsPtr));
            }
            return res;
        }
        long value = 0;
        int op = chsPtr++;
        for(int i = 0; i <  length; i++){
            value = value * 10 + nums[i] - '0';
            chs[chsPtr++] = nums[i];

            //Recursively call the helper method to build up the list
            chs[op] = '+';
            helper(i + 1, chsPtr, cur + prev, value,
                    length, chs, res, target);
            chs[op] = '-';
            helper(i + 1, chsPtr, cur + prev, -value,
                    length, chs, res, target);

            chs[op] = '*';
            helper(i + 1, chsPtr, cur + prev, prev * value,
                    length, chs, res, target);

            if(value == 0)
                break;
        }
        return res;
    }

    public static void main(String[] args){

    }
}
