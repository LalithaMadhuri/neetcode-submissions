class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(dfs(cost, 0, new int[cost.length]), dfs(cost, 1, new int[cost.length])); // min cost from 0 or 1 index
        
    }

    private int dfs(int[] cost, int i, int[] memo){
        if(i >= cost.length)
            return 0;

        if(memo[i] != 0) return memo[i];

        memo[i] = cost[i] + Math.min(dfs(cost, i+ 1, memo), dfs(cost,i + 2, memo));

        return memo[i];
    }
}
