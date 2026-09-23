/*

cost = [1, 2, 3] cost[i] cost of taking a step from ith floor

1. (i + 1) floor or (i + 2) floor
2. Start from index 0 or 1
3. Minimum cost to reach top of staircase => cost.length 

DP
1. Overlapping subproblem
 top = 3
    
    0,1                        1
    / \                       /  \
    1,3  2,4                 2.   3
    /\ /\                    / \. / \
    2,6 3,4 3,4 4.                3 4  
    /\
    3,6 4

2. What state does dp maintain?

dp[i] maintains min cost to reach top from stair i => ith stair -> top 

3. Base case

index > cost.length => return 0
index == cost.length => reached top => return min cost



*/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(bottomUp(cost,0, new int[cost.length+ 1]), bottomUp(cost, 1, new int[cost.length + 1]));
        
    }
    private int bottomUp(int[] cost, int index, int[] memo){
        if(index > cost.length) return 0;
        if(index == cost.length) return 0;
        if(memo[index] != 0) return memo[index];


        memo[index] = cost[index] + Math.min(bottomUp(cost, index + 1, memo), bottomUp(cost, index + 2, memo));
        return memo[index];
    }
}
