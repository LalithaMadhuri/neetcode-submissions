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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;

        int[] res = new int[1];
        dfs(root, res);
        return res[0];
        
    }
    private int dfs(TreeNode root, int[] res){
        if(root == null)
            return 0;

        int left_depth = dfs(root.left, res);
        int right_depth = dfs(root.right, res);
        res[0] = Math.max(res[0], left_depth + right_depth); // calculates diameter

        return 1 + Math.max(left_depth, right_depth); // always return depth to parent

        
    }
}
