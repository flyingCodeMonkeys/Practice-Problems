package TwoStrings;

import java.io.*;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = Result.twoStrings(s1, s2);

                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
    }
}
