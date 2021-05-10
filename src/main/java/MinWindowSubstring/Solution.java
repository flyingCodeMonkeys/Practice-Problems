package MinWindowSubstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        String ans = "";

        if(s.length() == 0 || t.length() == 0)
            return ans;

        Map<Character, Integer> frequencyMap = new HashMap();
        for(char c : t.toCharArray()){
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0)+1);
        }

        int max_l = t.length();
        int compPtr = 0;
        int right = -1;
        int left = -1;
        

        Map<Character, Integer> comp = new HashMap<>();
        while(true){
            boolean first = false;
            boolean second =false;
            while(right<s.length()-1 && compPtr<max_l){

                right++;
                comp.put(arr2[right],comp.getOrDefault(arr2[right],0)+1);
                if(comp.getOrDefault(arr2[right],0)<= frequencyMap.getOrDefault(arr2[right],0)){
                    compPtr++;
                }

                first=true;
            }

            while(left < right && compPtr == max_l){
                left++;
                String c = s.substring(left, right+1);
                //    System.out.println(c);
                if(ans.length()==0 || ans.length() > c.length()){
                    ans = c;
                }

                if(comp.get(arr2[left])==1){
                    comp.remove(arr2[left]);
                }
                else{
                    comp.put(arr2[left],comp.get(arr2[left])-1) ;
                }

                if(comp.getOrDefault(arr2[left],0)<frequencyMap.getOrDefault(arr2[left],0)){
                    compPtr--;
                }

                second = true;
            }

            if(first == false && second ==false)
                break;


        }

        Arrays.stream(new String[] { "Alpha", "Beta", "Gamma"}).map(i -> {
            System.out.println(i);
            return i;
        });

        return ans;
    }
}
