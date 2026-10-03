/*

2D grid a) 0 -> Empty b) 1 -> fresh c) 2 -> rotten

1. Every minute => a fresh fruit adjacent to rotten fruit is also rotten
2. Minimum number of minutes to make all the fruits rotten else -1

Classic BFS!!

1. Pattern - BFS

    BFS suits well here because 
    a) Minimum number of minutes it takes to make all fruits rotten should be returned

2. Definition of BFS

    bfs represents the state of the grid with rotten and fresh fruits after every minute elapses

3. High level idea

    Flip the idea => Find ROTTEN fruits first!

    1. Initialize freshOranges and set them to the number of fresh oranges in grid and number of minutes to -1 
    2. Add rotten fruit cells to a queue
    3. for each element in queue
        Pop element 
        for each direction
            newRow = row + dir, newCol = col + dir
            if newRow, newCol is boundary => continue
            if newRow, newCol != ROTTEN => continue

            make newRow,newCol ROTTEN
            add it to queue
            freshOranges--

        numOfMinutes++
    4. If fresh organges == 0 => return numOfMinutes else -1




*/

class Solution {
    public int orangesRotting(int[][] grid) {
        int ROW = grid.length, COL = grid[0].length, freshOranges = 0, numOfMinutes = -1;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(grid[i][j] == 2)
                    queue.offer(new Pair<>(i, j));
                else if(grid[i][j] == 1)
                    freshOranges++;
            }
        }

        if(freshOranges == 0) return 0;
        

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                Pair<Integer, Integer> row_col = queue.poll();
                for(int[] dir: dirs){
                    int newRow = row_col.getKey() + dir[0], newCol = row_col.getValue() + dir[1];
                    if(newRow < 0 || newCol < 0 || newRow >= ROW || newCol >= COL || grid[newRow][newCol] != 1) continue;


                    grid[newRow][newCol] = 2;
                    queue.offer(new Pair<>(newRow, newCol));
                    freshOranges--;
                    
               
                }
            }

            numOfMinutes++;    
        }

        return freshOranges == 0 ? numOfMinutes: -1;

        
    }
}
