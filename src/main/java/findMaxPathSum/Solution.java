package findMaxPathSum;

/*
currMaxSum

Treenode max value = max(maxSum+its value; )


          5  - Maxsum = max(5 + 3, 5 + (-7))  //update global MaxSum counter as traverse
         / \
        -7  3 Maxsum = nodeValue

        parentNodeIndex = floor(currentIndex -1/2)

 */

public class Solution {
    int maxSum = Integer.MIN_VALUE;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int max_gain(TreeNode node){
     if(node == null) return 0;
     int leftMax = Math.max(max_gain(node.left), 0);
     int rightMax = Math.max(max_gain(node.right), 0);
     int currSum = node.val + leftMax + rightMax;
     maxSum = Math.max(maxSum, currSum);

     return node.val + Math.max(leftMax, rightMax);
   }

    public int maxPathSum(TreeNode node){
        max_gain(node);
        return maxSum;
    }


 	public static void main (String[] args) {
 		System.out.println("Hello Java");
 	}

}
