package deleteNodeBST;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null) return root;
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }
        else{
            //if the node has no children, delete it
            if(root.left == null && root.right == null){
                root = null;
            }
            //Process the left node
            else if(root.left != null){
                root.val = maxOfTree(root.left);
                root.left = deleteNode(root.left, root.val);
            }
            //Process the right node
            else{
                root.val = minOfTree(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    private int maxOfTree(TreeNode root) {
        if(root.right != null){
            return maxOfTree(root.right);
        }
        else{
            return root.val;
        }
    }

    private int minOfTree(TreeNode root) {
        if(root.left != null){
            return minOfTree(root.left);
        }
        else{
            return root.val;
        }
    }

}
