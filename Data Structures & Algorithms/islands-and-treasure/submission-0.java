class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length; 
        int INF = 2147483647;

        // queue of rows and columns
        Queue<int[]> q = new LinkedList<>();

        // STEP - 1: Add all gates to queue
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == 0)
                    q.offer(new int[]{i, j});
            }
        }

        if(q.isEmpty())
            return;

        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

        while(!q.isEmpty()){
            int[] row_col = q.poll();
            int row = row_col[0];
            int col = row_col[1];

            // STEP - 2: Visit all the neighbors
            for(int d = 0; d < directions.length; d++){
                // outbound conditions
                int r = row + directions[d][0];
                int c = col + directions[d][1];

                if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
                    continue;

                // STEP- 3: Skip cells that are NOT INF
                if(grid[r][c] != INF)
                    continue;

                grid[r][c] = grid[row][col] + 1;

                // STEP-4: Add neighbors to queue
                q.offer(new int[]{r,c});



            }

        }
        
    }
}
