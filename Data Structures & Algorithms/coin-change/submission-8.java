/*

denominations => 1, 5, 10, etc.
amount = 12

1. Fewest number of coins to reach target amount else -1

DP

1. Overlapping subproblem

  12
  /        \     \
  1&s(11). 5&s(7) 10&s(2)

  1&s(10) 5&s(6) 10&s(1). 1&s(6) 5&s(2)

  2. Definition of dp

  What state does dp store?

  dp[amt] represents min number of coins needed to make up amt

  3. Base cases

  amt < 0 => return most max value so that it cannot be considered while returning min coins
  amt == 0 => found a way to make up target amount => return 0 as no more coins are needed to reach target



amount = 12
if(amount < 0) return Integer.MAX_VALUE; => impossible
if(amount == 0) return 0; => 0 number of additional coins needed
for each coin 
    int numOfCoins = solve(coins, amount - coin);

    if(numOfCoins != Integer.MAX_VALUE)
        minNumOfCoins = Math.min(minNumOfCoins, 1 + numOfCoins);


*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        int numCoins = topDown(coins, amount, memo);
        return numCoins == Integer.MAX_VALUE ? -1: numCoins;   
    }

    private int topDown(int[] coins, int remainingAmt, int[] memo){
        if(remainingAmt == 0) return 0;
        if(remainingAmt < 0) return Integer.MAX_VALUE;
        if(memo[remainingAmt] != -1) return memo[remainingAmt];

        int minCoins = Integer.MAX_VALUE;

        for(int coin: coins){
            int numCoins = topDown(coins, remainingAmt - coin, memo);

            if(numCoins != Integer.MAX_VALUE){
                minCoins = Math.min(minCoins, 1 + numCoins);
            }
        }
        memo[remainingAmt] = minCoins;
        return memo[remainingAmt];
    }


}
