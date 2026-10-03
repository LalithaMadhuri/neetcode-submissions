/*

2D grid 
    1. -1 -> Water X
    2. 0 -> Treasure \/
    3. INF -> Land \/

a) Fill each INF cell with distance to nearest treasure
b) If an INF cell can't reach Treasure leave with INF
c) Direction: up, down, right, left
d) Modify grid in place

1. Pattern - BFS
    BFS suits this for the following reasons - 
        a) Fill each land cell with distance to the NEAREST treasure

2. Definition of BFS
    BFS returns the distance of an INF cell to the nearest treasure

3. High level idea

    Flip the main ask of finding distance to the nearest gate 
    Instead find the trasure cells first, visit them and find their distance to each INF cell

    [(0, 2), (3, 0)]

    1. Add all treasure gate cells to queue
    2. Pop each element from queue
        for each direction
            newRow = row + dir, newCol = col + dir
            if boundary or water or !INF => continue
            
            grid[newRow][newCol] = grid[row][col] + 1
            add (newRow, newCol) to queue
        

*/

class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(grid[i][j] == 0)
                        queue.offer(new Pair<>(i, j));

            }
        }

        while(!queue.isEmpty()){
            Pair<Integer, Integer> row_col = queue.poll();

            for(int[] dir: dirs){
                int newRow = row_col.getKey() + dir[0], newCol = row_col.getValue() + dir[1];

                if(newRow < 0 || newCol < 0 || newRow >= ROW || newCol >= COL || grid[newRow][newCol] != Integer.MAX_VALUE)
                    continue;

                grid[newRow][newCol] = 1 + grid[row_col.getKey()][row_col.getValue()];
                queue.offer(new Pair<>(newRow, newCol));
            }

        }

        
    }
}
