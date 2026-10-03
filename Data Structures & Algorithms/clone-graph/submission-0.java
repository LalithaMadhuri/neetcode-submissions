/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

/*

Given a graph => return its cloned copy

1. Pattern - DFS

    DFS fits this usecase for 
     a) Helps identify reachable components from node
     b) Helps detect if there are cycles int he graph

2. Definition of DFS function

    dfs() returns cloned copy of a given "node"

3. High level idea

    dfs(node, map)
        if node in map return cloned copy

        create a clone

        add node -> clone to map

        for each neighbor of node 
            Node clone = dfs(neighbor, map)
            add neighbor -> clone mapping to map



4. Base case 
    if node is visited return its cloned copy

   

*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;

        System.out.println(node);

        Map<Node, Node> mapping = new HashMap<>();

        return  dfs(node, mapping);
        
    }

    private Node dfs(Node node,Map<Node, Node> mapping){
        if(mapping.containsKey(node))   
            return mapping.get(node);

        Node clone = new Node(node.val);

        mapping.put(node, clone);

        for(Node neighbor: node.neighbors){
            if(!mapping.containsKey(neighbor)){
                Node cloneNeighbor = dfs(neighbor, mapping);
                clone.neighbors.add(cloneNeighbor);
            }
            else
                clone.neighbors.add(mapping.get(neighbor));
        }
        return clone;

    }
}