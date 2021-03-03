package FirstNonRepeatingCharacter;

import java.util.HashMap;

public class Solution {
    static class CountIndex {
        int count;
        int index;

        public CountIndex(int index) {
            this.count = 1;
            this.index = index;
        }

        public void incCount() {
            this.count++;
        }
    }

    static final int NO_OF_CHARS = 256;

    static HashMap<Character, CountIndex> hm
            = new HashMap<Character, CountIndex>(NO_OF_CHARS);

    /* calculate count of characters
    in the passed string */
    static void getCharCountArray(String str)
    {
        for (int i = 0; i < str.length(); i++) {
            // If character already occurred,
            if (hm.containsKey(str.charAt(i))) {
                hm.get(str.charAt(i)).incCount();
            }
            else {
                hm.put(str.charAt(i), new CountIndex(i));
            }
        }
    }

    /* The method returns index of first non-repeating
    character in a string. If all characters are repeating
    then returns -1 */
    static int firstNonRepeating(String str) {
        getCharCountArray(str);
        int result = Integer.MAX_VALUE, i;

        for (i = 0; i < str.length(); i++) {
            // If this character occurs only once and appears
            // before the current result, then update the result
            if (hm.get(str.charAt(i)).count == 1
                    && result > hm.get(str.charAt(i)).index) {
                result = hm.get(str.charAt(i)).index;
            }
        }

        return result;
    }
}
