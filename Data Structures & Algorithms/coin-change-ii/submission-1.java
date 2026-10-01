/*

coins = [1, 2, 3]; amount = 4

1. Number of distinct combinations that total up amount
2. If not possible return 0

2D DP

1. Overlapping subproblem


4 
Level 1 : 1 & solve(3); 2 & solve(2);  3 & solve(1)

solve(3) => 1 & solve(2); 2 & solve(1); 3 & solve(0)

solve(2) => 1 & solve(1) ; 2 & solve(0)

solve(1) => 1 & solve(0)

Additional piece of information needed => coin denomination + remaining amount

2. Definition of dp

    index => specifies the coin denomination index
    remainingAmount => specifies the remaining amount possible


dp[index][remainingAmount] represents number of unique combinations possible with a coin denomination at index to make remaining amount value 

3. Base case 

remaining amount == 0 => we've found a combination => return 1
remaining amount < 0 => return 0


For every coin denomination 
a) Skip it
b) subtract curr coins[index] from remainingAmount

Consider a) or b)




*/


class Solution {
    int[] coins;
    public int change(int amount, int[] coins) {
        this.coins = coins;

        return numOfWays(0, amount, new Integer[coins.length + 1][amount + 1]);
        
    }

    private int numOfWays(int index, int remainingAmt, Integer[][] memo){
        if(index == coins.length && remainingAmt > 0) return 0;
        if(remainingAmt < 0) return 0;
        if(remainingAmt == 0) return 1;
        if(memo[index][remainingAmt] != null) return memo[index][remainingAmt];

        int skip = numOfWays(index + 1, remainingAmt, memo);
        int consider = numOfWays(index, remainingAmt - coins[index], memo);

        memo[index][remainingAmt] = skip + consider;
    

        return memo[index][remainingAmt];
    }
}
