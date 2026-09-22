class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(bottomUp(cost, 0, new int[cost.length]), bottomUp(cost, 1, new int[cost.length]));
    }
    private int bottomUp(int[] cost, int i, int[] memo){
        if(i == cost.length) // reached stairs
            return 0;

        if(i > cost.length)
            return 0;

        if(memo[i] != 0) return memo[i];

        memo[i] = cost[i] + Math.min(bottomUp(cost, i+1, memo), bottomUp(cost, i+2, memo));
        

        return memo[i];

        
    }
}
