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
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return false;

        return dfs(root,null, null);  
        
    }
    private boolean dfs(TreeNode root, Integer low, Integer high){
        if(root == null)
            return true;

        if((low != null && root.val <= low) || (high != null && root.val >= high)) // ensure that curr node val is between low and high range
            return false;
        return dfs(root.left, low, root.val) && dfs(root.right, root.val, high);
    }
}
