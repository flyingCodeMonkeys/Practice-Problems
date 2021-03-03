package LetterComboPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Map out every letter combination from the given input
 *
 * first create map of key value pairs from phone digits
 * next parse the inputted digits and iterate them against the values
 */

public class Solution {
    public List<String> letterCombinations(String digits) {

        Map<Character, String> dict = new HashMap<>();
        dict.put('2',"abc");
        dict.put('3',"def");
        dict.put('4',"ghi");
        dict.put('5',"jkl");
        dict.put('6',"mno");
        dict.put('7',"pqrs");
        dict.put('8',"tuv");
        dict.put('9',"wxyz");
        List combos = new ArrayList();

        for(int i = 0; i < digits.length(); i++) {
            combos.add(dict.get(digits.charAt(i)));
        }
        rec(0, "", new ArrayList<>(), combos);
        return combos;
    }

    private void rec(int index, String text, List answer, List combos) {
        if (index == combos.size()) {
            answer.add(text);
            return;
        }
        combos.add(answer);
    }

}
