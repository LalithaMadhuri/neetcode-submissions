/*

grid of 0s and 1s

area of an island = number of cells within that island

1. Max area of an island

BFS or DFS

1. Pattern- DFS

 DFS because we're trying to 
    a) find number of islands(find connected components)
    b) maximize the area

2. Definition of dfs

    DFS(row, col, visited) => returns the area of an island

3. High level idea

    for each row
        for each col
            if grid[row][col] == land and NOT visited
                area = Math.max(dfs(row, col, visited, area))

    return area;

    dfs(row, col, visited)
        1. check boundaries return
        2. if water return
        3. if visited return
        4. calculate area for current island by adding recursive functions
            dfs(r + 1, c) +
            dfs(r, c + 1) + 
            dfs(r - 1, c) +
            dfs(r, c - 1)
*/

class Solution {
    int ROW, COL;
    int[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.ROW = grid.length;
        this.COL = grid[0].length;

        int area = 0;

        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(grid[i][j] == 1)
                {
                    area = Math.max(area, dfs(i, j));
                }
            }
        }
        return area;

        
    }

    private int dfs(int r, int c){
        if(r < 0 || c < 0 || r >= ROW || c >= COL)
            return 0;
        if(grid[r][c] == 0)
            return 0;
        
        grid[r][c] = 0;

        return 1 + dfs(r + 1, c) + dfs(r, c + 1) + dfs(r - 1, c) + dfs(r, c - 1);
    }
}
