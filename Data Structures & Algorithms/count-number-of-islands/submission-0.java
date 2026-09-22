class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        int islands = 0, ROWS = grid.length, COLS = grid[0].length;

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++) {
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    islands++;
                }

            }
        }
        return islands; 
    }
    private void dfs(char[][] grid, int row, int col){

        // check out of bounds
        if(row >= grid.length || row < 0 || col >= grid[0].length || col < 0)
            return;

        if(grid[row][col] == '0' || grid[row][col] == '*')
            return;

        grid[row][col] = '*';

        dfs(grid, row + 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row - 1, col);
        dfs(grid, row, col - 1);

    }
}
