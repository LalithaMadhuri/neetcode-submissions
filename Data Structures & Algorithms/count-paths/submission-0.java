/*

Grid = m x n

1. Number of unique ways to reach from grid[0][0] to grid[m - 1][n - 1]
2. Can only move DOWN(m + 1) or RIGHT(n + 1)

m = 3, n = 3

output = 6

2d dp

1. Optimal substructure

 2 choices 
 a) Move down
 b) Move right

 add both choices to find unique ways => a) + b)

2. Definition of dp

 row => tracks the row that is being iterated
 col => tracks the col that is being iterated

 dp[row][col] specifies the number of unique paths from row and col to the corner m - 1 and n - 1

 Recurrence relation

 dp[row][col] = dp[row + 1][col] + dp[row][col + 1]

3. Base cases
 
 row == m - 1 && col == n - 1 => we found a distinct way to reach corner => return 1
 row == m  => return 0 
 col == n  => return 0 





*/


class Solution {
    int m;
    int n;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;

        return bottomUp(0, 0, new Integer[m + 1][n + 1]);
        
    }
    private int bottomUp(int row, int col, Integer[][] memo){
        if(row == m - 1 && col == n - 1) return 1;
        if(row == m) return 0;
        if(col == n) return 0;
        if(memo[row][col] != null) return memo[row][col];

        memo[row][col] = bottomUp(row + 1, col, memo) + bottomUp(row, col + 1, memo);

        return memo[row][col];
    }
}
