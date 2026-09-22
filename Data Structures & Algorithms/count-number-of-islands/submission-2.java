class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0, ROWS = grid.length, COLS = grid[0].length;

        for(int i = 0; i<ROWS; i++){
            for(int j =0; j < COLS; j++){
                if(grid[i][j] == '1'){
                    dfs(i,j,grid, ROWS, COLS);
                    islands++;
                }

            }
        }
        return islands;
        
    }
    private void dfs(int row, int col,char[][] grid, int ROWS, int COLS){
        // check bounds
        if(row < 0 || col < 0 || row >= ROWS || col >= COLS)
            return;

        if(grid[row][col] == '0' || grid[row][col] == '*')
            return;

        grid[row][col] = '*'; // already visited

        dfs(row - 1, col, grid, ROWS, COLS);
        dfs(row, col - 1,grid, ROWS, COLS);
        dfs(row + 1, col,grid, ROWS, COLS);
        dfs(row, col + 1,grid, ROWS, COLS);

    }
}
