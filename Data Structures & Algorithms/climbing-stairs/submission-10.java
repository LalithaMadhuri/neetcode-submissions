/*

n = 5

1 step

2 steps

overlapping subproblem

Base case
i == 0 => return 0
i == 1 => 1 way
i == 2 => 2 ways

dp(i - 1) + dp(i - 2)

    0
  /. \
  1.  2
  /\. /\
  2 3 3 4
  /\/\ /\ /\
  3445 45 5 6


*/
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
