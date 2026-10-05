/*

2d grid => cell reprsents height above sea leve;

Water can flow
a) 4 directions
b) height equal to or lower
c) cells adjacent to the ocean


Find cells where water can flow
a) from curr cell to both pacific and atlantic oceans



Entire top and left border can flow into pacific => check if they can flow into Atlantic
Entire bottom and right border can flow into Atlantic => check if they can flow into Pacific

cell (0, n - 1) and (m - 1, 0) can flow into both Pacific and Atlantic


queue 
 

visited = 

original flow => current cell >= neighbor cell
reverse flow => current cell <= neighbor cell => mark neighbor cell as true 


pacific =   
true true true true true
true true true true true
true false false false false 







*/

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
    
        int m = heights.length, n = heights[0].length;

        Boolean[][] pacific = new Boolean[m + 1][n + 1];
        Boolean[][] atlantic = new Boolean[m + 1][n + 1];

        Queue<Pair<Integer, Integer>> pacificQueue = new LinkedList<>();
        Queue<Pair<Integer, Integer>> atlanticQueue = new LinkedList<>();


        for(int j = 0; j < n; j++){
            pacific[0][j] = true;
            atlantic[m - 1][j] = true;

            pacificQueue.offer(new Pair<>(0, j));
            atlanticQueue.offer(new Pair<>(m - 1, j));
        }

        for(int i = 0; i < m; i++){
            pacific[i][0] = true;
            atlantic[i][n - 1] = true;

            pacificQueue.offer(new Pair<>(i, 0));
            atlanticQueue.offer(new Pair<>(i, n - 1));
        }

        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        while(!pacificQueue.isEmpty()){
            Pair<Integer, Integer> cell = pacificQueue.poll();
            int r = cell.getKey(), c = cell.getValue();

            for(int[] dir: dirs){
                int row = r + dir[0], col = c + dir[1];

                if(row < 0 || col < 0 || row >= m || col >= n)
                    continue;
                if(pacific[row][col] != null || heights[row][col] < heights[r][c])
                    continue;

                pacific[row][col] = true;
                pacificQueue.offer(new Pair<>(row,col));

            }

        }

        while(!atlanticQueue.isEmpty()){
            Pair<Integer, Integer> cell = atlanticQueue.poll();
            int r = cell.getKey(), c = cell.getValue();

            for(int[] dir: dirs){
                int row = r + dir[0], col = c + dir[1];

                if(row < 0 || col < 0 || row >= m || col >= n)
                    continue;
                if(atlantic[row][col] != null || heights[row][col] < heights[r][c])
                    continue;

                atlantic[row][col] = true;
                atlanticQueue.offer(new Pair<>(row,col));

            }

        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(pacific[i][j] != null && atlantic[i][j] != null && pacific[i][j] && atlantic[i][j])
                    res.add(List.of(i, j));
            }
        }
        return res;

        



        
            

        
        
        
    }
}
