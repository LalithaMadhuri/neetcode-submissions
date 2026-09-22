class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length, COLS= grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = new int[][]{{-1,0}, {0, 1}, {0, -1}, {1,0}};

        for(int i=0; i< ROWS; i++){
            for(int j = 0; j<COLS; j++){
                // search for treasure/gate
                if(grid[i][j] == 0){
                    // perform bfs
                    q.offer(new int[]{i,j});

                }
            }
        }

        while(!q.isEmpty()){
            int[] row_col = q.poll();
            int row = row_col[0];
            int col = row_col[1];

            for(int[] d: directions){
                int r = row + d[0];
                int c = col + d[1];

                // check bounds
                if(r < 0 || c < 0 || r >= ROWS || c >= COLS)
                    continue;

                if(grid[r][c] != Integer.MAX_VALUE) // value != INF cannot be traversed
                    continue;

                grid[r][c] = grid[row][col] + 1; // distance nearest to treasure/gate

                q.offer(new int[]{r,c});

            }
        }

        
    }
}
