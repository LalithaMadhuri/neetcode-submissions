class Solution {
    public int climbStairs(int n) {
        return dfs(n, 0, new int[n]);
        
    }
    private int dfs(int n, int start, int[] memo){
        if(start == n) // we've found a way to reach the top
            return 1;
        if(start > n) // we've crossed the top and that's not a valid way to climb
            return 0;
        
        if(memo[start] != 0) return memo[start];

        memo[start] = dfs(n, start+1, memo) + dfs(n, start + 2, memo);

        return memo[start];
    }
}
