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
        if(root == null)
            return true;

        boolean[] res = new boolean[1];
        res[0] = true;
        dfs(root, res);
        return res[0];
    }
    private int dfs(TreeNode root, boolean[] res){
        if(root == null)
            return 0;

        int left_depth = dfs(root.left, res);
        int right_depth = dfs(root.right, res);

        if(Math.abs(left_depth - right_depth) > 1){
            res[0] = false;
            return 0;
        }
            
        return 1 + Math.max(left_depth, right_depth);
        
    }
}
