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
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);

        for(int i = 1; i < res.size(); i++){
            if(res.get(i-1) >= res.get(i))
                return false;
        }
        return true;
        
    }
    private void inOrder(TreeNode root, List<Integer> res){
        
        // visit left subtree
        if(root.left != null)
            inOrder(root.left, res);

        res.add(root.val);

        if(root.right != null)
            inOrder(root.right, res);
    }
}
