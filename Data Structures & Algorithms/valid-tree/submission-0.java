/*
n nodes => 0 to n - 1

A tree should have
    a) No cycles
    b) All nodes connected (no disconnected components)

1. Pattern - 
    DFS works here as we're trying to detect cycles and also check connectivity or reachability from one node to another

2. Definition of dfs - 

    dfs() represents 
     a) if all nodes are connected or visited
     b) if there is a cycle

3. Information to remember(visited, visiting, parent, memo)
    a) visited set
    b) parent node

4. What to do when I see a neighbor?
    a) check if neighbor is in visited
    b) check cycle => if a) AND neighbor != parent(node)
        0 - 1 - 2 - 0 => <0, 1, 2> dfs(2, 1) 2 has neighbors 1 and 0, we ignore 1 as its the parent of 2 and thats how we reached 2. If we idenitfy another node already in visited set => 0 != parentNode hence theres a cycle
    c) add to visited

5. When to mark a node visited?
    before its neighbors are being explored

6. What does DFS return?
    a) a boolean value specifying if there is a cycle or not


dfs(node, parent) => returns boolean if a node has a cycle

visited => to keep track of nodes visited

neighbor is in visited AND parent != neighbor => CYCLE!

dfs(2, 1)
    dfs(3, 2)
        dfs(2, 3) => neighbor == parent so ignore or skip
        dfs(3, 1) => neighbor in visited set and neighbor != parent => CYCLE!
    dfs(1, 2) => neighbor == parent so ignore or skip

<0, 1, 2, 





*/

class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        for(int i = 0; i < edges.length; i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        System.out.println(adjList);

        Set<Integer> visited = new HashSet<>();

        if(dfs(0, -1, visited, adjList))
            return false;

        
        return visited.size() == n ? true: false;


    }

    private boolean dfs(int node, int parent, Set<Integer> visited, List<List<Integer>> adjList){
        if(visited.contains(node)) return false;

        visited.add(node);

        for(int neighbor: adjList.get(node)){
           
                if(neighbor == parent) continue;
                if(visited.contains(neighbor) && neighbor != parent)
                    return true;
                
                if(dfs(neighbor, node, visited, adjList))
                    return true;
            
        }
        return false;

    }
}
