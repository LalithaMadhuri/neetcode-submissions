/*

grid of 0's and 1's 
1. Return number of islands
2. Island is formed by connecting lands(1) horizontally or vertically (right or left or up or  down) and is Surrounded by water
3. All edges are water => m + 1, n + 1, -1, -1 are water

1. Pattern: Depth first search 

DFS because we need to first check if the adjacent cell is land/water to determine if an island is found 

2. Definition of DFS

    DFS(row, col) represents ONE entire island being explored

2. High level idea

  r => row
  c => col


  for each row
    for each col
        if grid[r][c] == land
            DFS(r, c)
            islands++ as dfs(r,c) explores one whole island

  DFS(r,c)
    1. check boundaries 
    2. if water
        skip
    3. if land 
        if (r, c) not visited
            add (r,c) to visited set
            dfs(r+1, c)
            dfs(r, c+1)
            dfs(r-1, c)
            dfs(r, c-1)







*/

class Solution {
    int ROW;
    int COL;
    char[][] grid;
    
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.ROW = grid.length;
        this.COL = grid[0].length;

        Set<Pair<Integer, Integer>> visited = new HashSet<>();


        int islands = 0;

        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(grid[i][j] == '1' && !visited.contains(new Pair<>(i, j))){
                    dfs(i, j, visited);
                    islands++;
                }

            }
        }
        return islands;
        
        
    }

    private void dfs(int r, int c, Set<Pair<Integer,Integer>> visited){
        if(r < 0 || c < 0 || r >= ROW || c >= COL)
            return;

        if(grid[r][c] == '0') return;
        if(visited.contains(new Pair<>(r, c))) return;

        visited.add(new Pair<>(r, c));
        dfs(r, c+1, visited);
        dfs(r + 1, c, visited);
        dfs(r - 1, c, visited);
        dfs(r, c - 1, visited);
        

    }
}
