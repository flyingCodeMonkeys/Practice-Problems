package NChooseK;
/*Prompt

Given two integers n and k, return all possible combinations of k numbers from 1 to n.
  Examples:

n = 4
k = 2

result =
  [
    [1, 2],
    [1, 3],
    [1, 4],
    [2, 3],
    [2, 4],
    [3, 4],
  ]

n = 3
k = 1

result =
  [
    [1],
    [2],
    [3],
  ]


n = 5
k = 3

[
  [1,2,3]
  [1,2,4]
  [1,2,5]
  ...



]



Input:

n = Integer

k = Integer
Output

result = Array of Arrays of Integers
Constraints:

Time: O(n choose k)

Space: O(n choose k)

The order of the output array DOES NOT MATTER.

n and k are both positive.

*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        DFS(n, k, 1, current, result);
        return result;
    }

    public void DFS(int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (k==0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {
            current.add(i);
            DFS(n, k - 1, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

}
