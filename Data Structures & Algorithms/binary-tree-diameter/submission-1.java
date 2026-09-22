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
        int[] res = new int[1];
        dfs(root, res);
        return res[0];

        
    }

    private int dfs(TreeNode root, int[] res){
        if(root == null)
            return 0;

        int left_subtree_height = dfs(root.left, res);
        int right_subtree_height = dfs(root.right, res);
        // keep track of longest path till now
        res[0] = Math.max(res[0], left_subtree_height + right_subtree_height);

        // return height of curr node to parent
        return 1 + Math.max(left_subtree_height,right_subtree_height);
    }
}
