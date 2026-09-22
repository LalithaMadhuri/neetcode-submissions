class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int islands = 0, area = 0, ROWS = grid.length, COLS = grid[0].length;

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == 1){
                    int ar = dfs(grid, i, j);
                    islands++;
                    area = Math.max(area, ar);
                }
            }
        }
        return area;
        
    }
    private int dfs(int[][] grid, int row, int col){
        if(row < 0 || col < 0|| row >= grid.length || col >= grid[0].length)
            return 0;

        if(grid[row][col] == 0)
            return 0;

        grid[row][col] = 0;
        int res = 1;
        

        res += dfs(grid, row + 1, col);
        res += dfs(grid, row, col + 1);
        res += dfs(grid, row - 1, col);
        res += dfs(grid, row, col - 1);
        return res;
    }
}
