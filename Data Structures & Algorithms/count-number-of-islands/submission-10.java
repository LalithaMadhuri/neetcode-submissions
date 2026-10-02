/*

grid of 0's and 1's 
1. Return number of islands
2. Island is formed by connecting lands(1) horizontally or vertically (right or left or up or  down) and is Surrounded by water
3. All edges are water => m + 1, n + 1, -1, -1 are water

1. Pattern: Depth first search 

DFS because we need to first check if the adjacent cell is land/water to determine if an island is found 

2. Definition of DFS

    DFS(row, col) represents ONE entire island being explored

2. High level idea

  r => row
  c => col


  for each row
    for each col
        if grid[r][c] == land
            DFS(r, c)
            islands++ as dfs(r,c) explores one whole island

  DFS(r,c)
    1. check boundaries 
    2. if water
        skip
    3. if land 
        if (r, c) not visited
            add (r,c) to visited set
            dfs(r+1, c)
            dfs(r, c+1)
            dfs(r-1, c)
            dfs(r, c-1)







*/

class Solution {
    int ROW;
    int COL;
    char[][] grid;
    
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.ROW = grid.length;
        this.COL = grid[0].length;



        int islands = 0;

        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COL; j++){
                if(grid[i][j] == '1'){
                    bfs(i, j);
                    islands++;
                }

            }
        }
        return islands;
        
        
    }

    private void bfs(int r, int c){
        
        int[][] ROW_COL = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


        Queue<Pair<Integer, Integer>> queue = new LinkedList();
        grid[r][c] = '0';
        queue.add(new Pair<>(r, c));

        while(!queue.isEmpty()){
            int size = queue.size();

            Pair<Integer, Integer> r_c = queue.poll();
            int row = r_c.getKey(),col = r_c.getValue();
            
            for(int[] m_n: ROW_COL){
                int m = row + m_n[0], n = col + m_n[1];

                if(m < 0 || n < 0 || m >= ROW || n >= COL || grid[m][n] == '0')
                    continue;

               
                queue.add(new Pair<>(m, n));
                grid[m][n] = '0';

            }
        }

        
        

    }
}
