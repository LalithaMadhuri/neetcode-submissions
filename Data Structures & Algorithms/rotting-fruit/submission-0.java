class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh_oranges = 0, minutes_elapsed = -1;
        int[][] directions = new int[][]{{-1,0}, {0, -1}, {1, 0}, {0, 1}};
        // add infected oranges
        Queue<int[]> q = new LinkedList<>();

        int ROWS = grid.length, COLS = grid[0].length;

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(grid[i][j] == 2)
                    q.offer(new int[]{i,j});
                else if(grid[i][j] == 1)
                    fresh_oranges += 1;
            }
        }

        // add marker to queue specifying that 1 additional minute has elapsed
        q.offer(new int[]{-1, -1});


        // BFS
        while(!q.isEmpty()){
            int[] row_col = q.poll();
            int row = row_col[0], col = row_col[1];

            if(row == -1){
                minutes_elapsed += 1;
                if(!q.isEmpty())
                    q.offer(new int[]{-1, -1});
            }

            

            for(int m=0; m < directions.length; m++){
                int nei_row = row + directions[m][0];
                int nei_col = col + directions[m][1];
                // check bounds
                if(nei_row >= ROWS || nei_col >= COLS || nei_row < 0 || nei_col < 0)
                    continue;

                if(grid[nei_row][nei_col] == 1){
                    q.offer(new int[]{nei_row, nei_col});
                    grid[nei_row][nei_col] = 2; // make it rotten
                    fresh_oranges -= 1;
                }
                
            }

        }

        System.out.println(minutes_elapsed);
        // if fresh oranges have been processed
        if(fresh_oranges == 0)
            return minutes_elapsed;
        
        else
            return -1;

        
        
    }
}
