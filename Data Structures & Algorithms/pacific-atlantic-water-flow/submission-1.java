class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean [][] atlantic = new boolean[ROWS][COLS];
        List<List<Integer>> res = new ArrayList<>();
        // ocean horizontal boundaries
        for(int c=0; c < COLS; c++){
            dfs(0, c, pacific, heights);
            dfs(ROWS - 1, c, atlantic, heights);
        }

        // ocean vertical boundaries
        for(int r = 0; r < ROWS; r++){
            dfs(r, 0, pacific, heights);
            dfs(r, COLS - 1, atlantic, heights);
        }
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(pacific[i][j] && atlantic[i][j])
                    res.add(List.of(i, j));
            }
        }
        return res;
        
    }
    private void dfs(int row, int col, boolean[][] ocean, int[][] heights){
        int ROWS = heights.length, COLS = heights[0].length;
        ocean[row][col] = true; // mark as visited
        int[][] directions = new int[][]{{-1,0}, {0, -1}, {0, 1}, {1, 0}};

        for(int d = 0; d < directions.length; d++){
            int r = row + directions[d][0];
            int c = col + directions[d][1];
            // check bounds
            if(r < ROWS && c < COLS && r >= 0 && c >= 0 
            && !ocean[r][c] && heights[r][c] >= heights[row][col])
                dfs(r, c, ocean, heights);
            
        }
    }
}
