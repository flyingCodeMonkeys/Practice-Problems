package FindMaximumXOR;

import java.util.HashMap;

public class Solution {


        class TrieNode {
            HashMap<Character, TrieNode> children = new HashMap<>();
            public TrieNode(){}
        }




    public int findMaximumXOR(int[] nums) {
        //Get length of max number in binary representation
        int maxNum = nums[0];

        for(int num:nums) {
            maxNum = Math.max(num, maxNum);
        }
        int binLength = (Integer.toBinaryString(maxNum)).length();

        int n = nums.length;
        int bitmask = 1 << binLength;

        String[] strNums = new String[n];
        for(int i = 0; i < n; i++) {
            strNums[i] =  Integer.toBinaryString(bitmask | nums[i]).substring(1);
        }

        TrieNode trie = new TrieNode();
        for(String num:strNums) {
            TrieNode xorNode = trie;
            int currXor = 0;

            for(Character bit : num.toCharArray()) {
                Character toggledBit = bit == '1' ? '0' : '1';
                if(xorNode.children.containsKey(toggledBit)) {
                    currXor = (currXor << 1) | 1;
                    xorNode = xorNode.children.get(toggledBit);
                }
                else {
                    currXor = currXor << 1;
                    xorNode = xorNode.children.get(bit);
                }
            }
        }

        return 0;
    }


}
