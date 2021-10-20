package TwoStrings;

import java.util.HashSet;
import java.util.Set;

class Result {

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static String twoStrings(String str1, String str2) {
        HashSet<Character> set1 = new HashSet<Character>();
        HashSet<Character> set2 = new HashSet<Character>();

        for(int i = 0; i < str1.length(); i++){
            set1.add(str1.charAt(i));
        }

        for(int i = 0; i < str2.length(); i++){
            set2.add(str2.charAt(i));
        }

        set1.retainAll(set2);
        if(set1.isEmpty()){
            return "NO";
        } else {
            return "YES";
        }

    }

}
