/*

Connected cyclic undirected graph => Connected non cyclic undirected graph

1. Problem - DFS
    DFS suits here because 
    a) we're trying to find connected components to check the reachability of a node

2. Definition of dfs
    dfs(u, v) represents if a node u can reach node v

3. Information needed 
    visited set to keep track of nodes being visited
4. dfs returns a boolean value specifying if a cycle has been found or not between u and v
5. 
   
   for every edge
    visited = set<>
    if(dfs(u, v))
        return [u, v]
    add [u, v] to adj list

    dfs(u, v)
        if u == v return true; 

        visited.add(u)

        for each neighbor of u
            if(dfs(u.neighbor, v))
                return true;

        return false;

[]

dfs(Node u, Node v)
    if(u can reach v) => return 

    dfs(u.neighbor, v);
    add [u, v] to adjacency list


*/
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 1; i <= edges.length; i++)
            adjList.add(new ArrayList<>());
        

        for(int[] edge: edges){
            Set<Integer> visited = new HashSet<>();
            if(dfs(edge[0] - 1, edge[1] - 1,visited, adjList))
                return new int[]{edge[0], edge[1]};
            adjList.get(edge[0] - 1).add(edge[1] - 1);
            adjList.get(edge[1] - 1).add(edge[0] - 1);
            

        }

        return new int[]{};
        
    }

    private boolean dfs(int u, int v, Set<Integer> visited, List<List<Integer>> adjList){
        if(u == v) return true;

        visited.add(u);

        for(int neighbor: adjList.get(u)){
            if(!visited.contains(neighbor)){
                if(dfs(neighbor, v, visited, adjList))
                    return true;
            }
        }
        return false;


    }
}
