/*

nodes labeled from 1 to n 
edges 

1. Pattern - Union Find 

    Reasons
    a) easily detect a cycle when trying to merge two nodes 

2. High level idea

    a) Process each edge
    b) if union(node1, node2) == true => found a cycle return edge(i,j)
    c) if union(node1, node2) == false => continue merging and connecting




*/

class Solution {
    int[] parent;
    int[] size;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        parent = new int[n + 1];
        size = new int[n + 1];

        Arrays.fill(size, 1);
        for(int i = 1; i <= n; i++)
            parent[i] = i;

        for(int i = 0; i <n; i++){
            if(!union(edges[i][0],edges[i][1]))
                return new int[]{edges[i][0], edges[i][1]};
        }
        return new int[]{};
        
    }

    private boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB)
            return false;

        if(size[rootA] >= size[rootB]){
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
        else{
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }
        return true;
    }

    private int find(int x){
        if(parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
}
