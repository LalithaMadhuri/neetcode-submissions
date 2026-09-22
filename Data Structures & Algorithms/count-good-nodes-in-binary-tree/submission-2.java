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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
        
    }
    private int dfs(TreeNode root, int maxVal){
        if(root == null)
            return 0;

        int count = 0;
        // found a good node
        if(root.val >= maxVal)
            count = 1;
        // keep track of maxVal observed till now
        maxVal = Math.max(maxVal, root.val);

        count += dfs(root.left, maxVal);
        count += dfs(root.right, maxVal);
        return count;

    }
}
