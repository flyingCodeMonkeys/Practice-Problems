package PathSum2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }

     public List<List<Integer>> pathSum(TreeNode root, int target) {
         List<Integer> runningAnswer = new ArrayList<>();
         List<List<Integer>> answers = new ArrayList<>();

         dfsFindAnswer(root, target, runningAnswer, answers);

         return answers;
     }

     public void dfsFindAnswer(TreeNode root, int target, List<Integer> answer
                                , List<List<Integer>> result) {
         if(root == null)
             return;
         answer.add(root.val);

         if(target == root.val && root.left == null && root.right == null) {
             result.add(new ArrayList<>(answer));
             answer.remove(answer.size() - 1);
             return;
         }

         dfsFindAnswer(root.left, target - root.val,
                 answer, result);


         dfsFindAnswer(root.right, target - root.val,
                answer, result);

         answer.remove(answer.size() - 1);

     }
}
