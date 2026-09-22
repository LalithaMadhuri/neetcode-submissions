class Solution {
    public int climbStairs(int n) {
        return topDown(n, new int[n + 1]); 
    }
    private int topDown(int n, int[] memo){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(memo[n] != 0) return memo[n];

        memo[n] = topDown(n - 1, memo) + topDown(n - 2, memo);
        
        return memo[n];
        
    }
}
