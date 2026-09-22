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
    int numOfGoodNodes = 0;
    public int goodNodes(TreeNode root) {
        if(root == null)
            return 0;
       
        dfs(root, Integer.MIN_VALUE);
        return numOfGoodNodes;
        
    }
    private void dfs(TreeNode root, int maxVal){ //maxVal keeps track of max value from root to curr node
        if(root == null)
            return;

        if(root.val >= maxVal) // found a good node
            numOfGoodNodes++;

        dfs(root.left, Math.max(root.val, maxVal));
        dfs(root.right, Math.max(root.val, maxVal));
    }
}
