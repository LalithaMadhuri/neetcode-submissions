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
 /*

 1. Problem type - DFS as we're trying to calculate the depth of a binary tree
 2. Main Idea - Use recursion
   
   Visit curr node
   for each neighbor of curr node
        if not visited
            recursively apply dfs
            Take max of recursion

    return 1 + max

 3. Base case

        root == null => return 0 as there is no node to count depth



 */

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        return dfs(root);
        
    }
    private int dfs(TreeNode node){
        if(node == null)
            return 0; 

        int left = 0, right = 0;

        if(node.left != null) left = dfs(node.left);
        if(node.right != null) right = dfs(node.right);

        return 1 + Math.max(left, right);

    }
}
