class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;

        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];
        List<List<Integer>> res = new ArrayList<>();

        for(int r = 0; r<ROWS; r++)
        {
            dfs(r, 0, pacific, heights); // left
            dfs(r, COLS-1, atlantic, heights); // right
        }

        for(int c=0; c<COLS;c++){
            dfs(0, c, pacific, heights); // top
            dfs(ROWS - 1, c, atlantic, heights); // bottom
        }

        for(int i = 0; i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(List.of(i,j));
                }
            }
        }
        return res;
        
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights){
        ocean[r][c] = true;

        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int ROWS = heights.length, COLS = heights[0].length;

        for(int[] d: directions){
            int row = r + d[0];
            int col = c + d[1];

            // check bounds
            if(row >= ROWS || col >= COLS || row < 0 || col < 0 )
                continue;

            if(heights[row][col] < heights[r][c] || ocean[row][col])
                continue;

            dfs(row, col, ocean, heights);
        }
    }
}
