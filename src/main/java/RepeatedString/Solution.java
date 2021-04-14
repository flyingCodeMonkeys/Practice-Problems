package RepeatedString;

public class Solution {

    public long repeatedString(String s, long n) {
        long whole = n / s.length();
        int remainder = (int) (n % s.length());
        long found = 0;

        for(char ch : s.toCharArray()) {
            if(ch == 'a'){
                found++;
            }
        }
        long total = found * whole;
        if(remainder == 0) {
            return total;
        }
        else {
            String part = s.substring(0, remainder);
            for(char ch : part.toCharArray()) {
                if(ch == 'a') {
                    total++;
                }
            }
        }
        return total;
    }
}
