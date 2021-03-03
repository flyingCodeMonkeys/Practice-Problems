package MultiplyStrings;

import java.util.ArrayList;
import java.util.List;

/**
 * In order to multiply big numbers efficiently, use Karatsuba method
 * 1) Split strings into equal size strings (num1 -> a,b ; num2 -> c,d)
 * 2) Compute starting at: a * c
 * 3) Compute next pair: b * d
 * 4) Subtract result of step 3 by the result of step 2, and product of step 1
 * 5) pad the numbers
 */

public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        else if (num1.equals("1"))
            return num2;
        else if (num2.equals("1"))
            return num1;

        int len1 = num1.length();
        int len2 = num2.length();

        int maxNumLength = Math.max(len1, len2);
        maxNumLength = (maxNumLength / 2) + (maxNumLength % 2);
        long getExpressions;
        int size = makeEqualLength(num1, num2);
        return "";
    }

    private int makeEqualLength(String num1, String num2){
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 < len2) {

        }
        return 0;
    }
}
