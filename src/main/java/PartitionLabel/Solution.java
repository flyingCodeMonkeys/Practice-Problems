package PartitionLabel;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> partitionLabels(String str) {
        List<Integer> partitionLengths = new ArrayList<>();
        int[] lastIndexes = new int[26];
        for(int i = 0; i < str.length(); i++) {
            lastIndexes[str.charAt(i) - 'a'] = i;
        }

        int i = 0;
        while(i < str.length()){
            int end = lastIndexes[str.charAt(i) - 'a'];
            int j = i;
            while(j != end){
                end = Math.max(end, lastIndexes[str.charAt(j++) - 'a']);
            }
            partitionLengths.add(j - i + 1);
            i = j + 1;
        }
        return partitionLengths;
    }
}
