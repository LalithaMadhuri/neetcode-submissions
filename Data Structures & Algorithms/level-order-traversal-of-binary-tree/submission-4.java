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

 1. Problem type: BFS as we're trying to find nodes level by level

 2. Main idea: 

 Queue => FIFO data structure

 Queue : [       ]
 Visited: [1,2, 3, 4, 5, 6, 7 ]

 Res: [[1] [2, 3] [4,5, 6, 7]]





 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(root);
        visited.add(root.val);


        while(!queue.isEmpty()){
        
            List<Integer> subRes = new ArrayList<>();

            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();

                subRes.add(node.val);

                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                    
                }

            }

            
            
            if(!subRes.isEmpty()) res.add(subRes);
            
        }
        return res;
        
    }
}
