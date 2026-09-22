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
        // if a node is null stop traversing
        if(root == null)
            return 0;

        // find left subtree depth
        int left_depth = maxDepth(root.left);
        // find right subtree depth
        int right_depth = maxDepth(root.right);
        // take the max of both and return depth
        return 1 + Math.max(left_depth, right_depth);
        
    }
}
