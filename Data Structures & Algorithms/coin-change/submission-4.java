class Solution {
    public int coinChange(int[] coins, int amount) {
        return topDown(coins, amount, new int[amount]);
        
    }
    private int topDown(int[] coins, int amount, int[] memo){
        if(amount < 0) return -1;
        if(amount == 0) return 0;
        if(memo[amount - 1] != 0) return memo[amount - 1];

        int minCount = Integer.MAX_VALUE;

        for(int coin: coins){
            int res = topDown(coins, amount - coin, memo);
            if(res != -1)
                minCount = Math.min(minCount, 1+ res); // count current coin + solve for rem amount
        }
        memo[amount - 1] = minCount == Integer.MAX_VALUE ? -1: minCount; 
        return memo[amount - 1];
    }
}
