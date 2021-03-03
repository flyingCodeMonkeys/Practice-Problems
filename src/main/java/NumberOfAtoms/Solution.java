package NumberOfAtoms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Solution {
    public String countOfAtoms(String formula) {

        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> map = new TreeMap<>();
        int i = 0;
        while(i < formula.length()) {
            char c = formula.charAt(i++);
            if(c =='(') {
                stack.push(map);
                map = new HashMap<>();
            }
        }
    }

    private class Atom {
        String name;
        int count;
        Atom(String name, int count){
            this.name = name;
            this.count = count;
        }
    }
}
