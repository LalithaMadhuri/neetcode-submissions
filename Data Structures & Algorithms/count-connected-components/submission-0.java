/*

undirected graph => 0 to n - 1

1. Number of connected components 

1. Problem type - DFS
    DFS suits here because 
        1. We're trying to find connected components and check the reachability of a node

2. definition of dfs
    dfs() represents number of connected components a given node has

3. Information to store 
    -> Visited set to store the nodes being visited

4. What does dfs return 
    One connected component of a given node

5. How should visited be populated?

    for each node in adjList
        dfs(node)
        numComponents++;
     Start dfs with current node 
        a)if already visited return 
        b)visit the current node
        c)for each of its neighbors 
            d) if neighbor not in visited
                    dfs(neighbor)
                    

    
    dfs(0) visited = <0, 1, 2,3, 4>
        dfs(1)
            dfs(0) => ignore 
            dfs(2)
                dfs(1) => ignore
                


*/


class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i =0; i < n; i++)
            adjList.add(new ArrayList<>());

        for(int i = 0; i < edges.length; i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        Set<Integer> visited = new HashSet<>();
        int numComponents = 0;

        for(int i = 0; i < adjList.size(); i++){
            if(!visited.contains(i)){
                dfs(i, visited, adjList);
                numComponents++;

            }
        }
        return numComponents;

    }

    private void dfs(int node, Set<Integer> visited, List<List<Integer>> adjList){
        if(visited.contains(node)) return;

        visited.add(node);

        for(int neighbor: adjList.get(node)){
            if(!visited.contains(neighbor))
                dfs(neighbor, visited, adjList);
        }
    }
}
