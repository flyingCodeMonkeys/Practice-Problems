package PDRI;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Task
 * In mathematics, a Diophantine equation is a polynomial equation,
 * usually in two or more unknowns, such that only the integer solutions
 * are sought or studied.
 *
 * In this challenge we want to find all integers x, y (x >= 0, y >= 0) solutions of a diophantine equation of the form
 *
 *  x ^ 2 - 4 * y ^ 2 = n
 * where the unknowns are x and y and n is a given positive number.
 *
 * Solutions x, y will be given as a string
 *
 *  "[[x1, y1], [x2, y2] ....]"
 * in decreasing order of the positive xi. If there is no solution returns "[]".
 *
 * Examples
 * solEquaStr(90005) --> "[[45003, 22501], [9003, 4499], [981, 467], [309, 37]]"
 *
 * solEquaStr(90002) --> "[]"
 * Hint
 * x ^ 2 - 4 y ^ 2 = (x - 2y) (x + 2y).
 *
 * n/(x - 2y) = x + 2y
 * n/(x - 2y) - 2y = x;
 */

public class Dioph {
    public static String solEquaStr(long n) {
        //Solve for solutions that result in n
        List<List> result = new ArrayList();

        Map<Integer, Integer> sol = new LinkedHashMap<Integer, Integer>();

        for(int i = 1; i < Math.sqrt(n)+1; i++) {
            if(n % i == 0) {
                int j = (int)Math.floor(n / i);
                if ((i + j) % 2 == 0 && (j - i) % 4 == 0) {
                    List pair = new ArrayList();
                    int x = (int)Math.floor((i + j) / 2);
                    int y = (int)Math.floor((j - i) / 4);
                    pair.add(x);
                    pair.add(y);
                    result.add(pair);
                }
            }

        }
        return result.size() > 0 ? result.toString() : "[]";
    }
}
