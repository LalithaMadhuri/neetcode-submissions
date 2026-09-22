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
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
        
    }
    private int dfs(TreeNode root){
        if(root == null)
            return 0;

        int left_subtree_height = dfs(root.left);
        if(left_subtree_height == -1)
            return -1;

        int right_subtree_height = dfs(root.right);
        if(right_subtree_height == -1)
            return -1;

        if(Math.abs(left_subtree_height - right_subtree_height) > 1)
            return -1;

        // return height to its parent
        return 1 + Math.max(left_subtree_height, right_subtree_height);
        

    }
}
