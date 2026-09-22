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

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int left_depth = root.left != null ? maxDepth(root.left) : 0;
        
        int right_depth = root.right != null ? maxDepth(root.right) : 0;

        return 1+ Math.max(left_depth,right_depth);
        
    }
}
