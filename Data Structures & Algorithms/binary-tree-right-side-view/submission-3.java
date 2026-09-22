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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> subRes = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                subRes.add(node.val);
                if(node.left != null) 
                    q.offer(node.left);
                if(node.right != null) 
                    q.offer(node.right);

            }
            res.add(subRes);
            
        }

        List<Integer> response = new ArrayList<>();
        
        for(int i = 0; i < res.size(); i++){
            response.add(res.get(i).get(res.get(i).size() - 1));

        }
        return response;
        
        
    }
}
