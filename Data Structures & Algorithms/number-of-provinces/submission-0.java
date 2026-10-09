/*

n number of cities

province -> group of directly or indirectly connected cities
  0 1 2
0 1 1 0
1 1 1 0
2 0 0 1

parent = [0 0 2]
n = 3
01 02 12
00 11 22
10 20 21

1 1 1 1     01 02 03 12 13 23
1 1 1 1
1 1 1 1
1 1 1 1

diagonals -> 00 11 22 .. nn
above diagonals -> 01 to 0 n - 1; 12 to 1 n - 1; 2 to n -1

n = 3
  0 1 2
0 1 0 1
1 0 1 1
2 1 1 1

parent = [0 0 0]
size = [3 1 1]

diffRoot = <0>

// above main diagonals
for(i = 0; i < n; i++)
    for(j = 0; j < n; j++)
        if(i >= j) continue;

        if(isConnected[i][j] == 1)
            diffRoot.add(union(i, j))

return diffRoot.size();
        

union(int i, int j, int[] parent)
    int rootA = find(i, parent);
    int rootB = find(j, parent);

    if(rootA == rootB)
        return rootA; // same group

    if(size[rootA] >= size[rootB])
        parent[rootB] = rootA;
        size[rootA] += size[rootB]
        return rootA;

    else
        parent[rootA] = rootB;
        size[rootB] += size[rootA];
        return rootB;



find(int x, int[] parent)
    if(parent[x] == x)
        return x;
    parent[x] = find(parent[x], parent);
    return parent[x];



1. Problem - Union Find

    Reasons
    a) find number of connected components or provinces by identifying groups that are connected together

2. High level idea

    a) Find parent of each city by identifying connection between ith and jth city
    b) Count the number of different parents => number of provinces


*/

class Solution {
    int[] parent;
    int[] size;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, provinces = isConnected.length;

        parent = new int[n];
        size = new int[n];

        Arrays.fill(size, 1);

        for(int i = 0; i < n; i++)
            parent[i] = i;

        // only handle upper diagonal
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i >= j) continue;

                if(isConnected[i][j] == 1){
                    if(union(i, j))
                        provinces--;
                }
            }
        }
        return provinces;
        
    }

    private boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) return false;

        if(size[rootA] >= size[rootB]){
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
            
        }
        else
        {
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