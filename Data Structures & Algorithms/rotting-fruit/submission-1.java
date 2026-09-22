class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh_oranges = 0, minutes_elapsed = -1;
        int ROWS = grid.length, COLS = grid[0].length;
        int[][] directions = new int[][]{{-1,0}, {0, 1}, {0, -1}, {1,0}};

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i<ROWS;i++){
            for(int j = 0; j<COLS;j++){
                if(grid[i][j] == 2)
                    q.offer(new int[]{i,j});
                if(grid[i][j] == 1)
                    fresh_oranges += 1;
            }
        }
        // marker
        q.offer(new int[]{-1, -1});

        while(!q.isEmpty()){
            int[] row_col = q.poll();
            int row = row_col[0];
            int col = row_col[1];

            if(row == -1){
                minutes_elapsed += 1;
                if(!q.isEmpty())
                    q.offer(new int[]{-1, -1});
            }

            for(int[] d: directions){
                int r = row + d[0];
                int c = col + d[1];

                // check bounds
                if(r < 0 || c < 0 || r >= ROWS || c >= COLS)
                    continue;

                if(grid[r][c] == 0) // empty cell
                    continue;

                if(grid[r][c] == 1){
                    grid[r][c] = 2;
                    fresh_oranges -=1;
                    q.offer(new int[]{r,c});
                }

                
            }


        }

        if(fresh_oranges == 0)
            return minutes_elapsed;
        return -1;
        
    }
}
