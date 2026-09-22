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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        // add root
        q.offer(root);

        while(!q.isEmpty()){
            int s = q.size();

            List<Integer> children = new ArrayList<>();

            for(int i = 0; i < s; i++){
                TreeNode n = q.poll();
                children.add(n.val);

                if(n.left != null)
                    q.offer(n.left);

                if(n.right != null)
                    q.offer(n.right);

            }
            res.add(children);
        }
        return res;
    }
}
