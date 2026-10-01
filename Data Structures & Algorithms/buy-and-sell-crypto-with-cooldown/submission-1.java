/*

prices = [1, 3, 4, 0, 4]

1. Buy and sell => Max profit
2. After selling there is a cooldown period of 1 day to resume buying and selling


2d dp

1. Optimal substructure

Choices
    HOLDING STOCK
        1. Sell stock at index i => calculate profit + move to (i + 2) index with holding = FALSE
        2. Skip price[i] => move to (i + 1) index 
    NOT HOLDING 
        1. Buy stock at index i => move to (i + 1) index with HOLDING = true
        2. Skip price[i] => move to (i + 1) index

2. Definition of dp

    index => represents the index of prices 
    status => represents holding status at index

    dp[index][status] => represnts the max profit that can be achieved from index i based on the status(HOLDING/NOT HOLDING)

3. Base case

    index == prices.length => return 0 as there is no price to calculate

*/



class Solution {
    int[] prices;
    public int maxProfit(int[] prices) {
        this.prices = prices;
        return bottomUp(0, 0, new Integer[prices.length + 1][2]);
        
    }
    private int bottomUp(int index, int status, Integer[][] memo){
        if(index >= prices.length) return 0;
        if(memo[index][status] != null) return memo[index][status];

        // NOT HOLDING
        if(status == 0){
            int buy = bottomUp(index + 1, 1, memo) - prices[index];
            int skip = bottomUp(index + 1, 0, memo);
            
            memo[index][status] = Math.max(buy, skip);
            return memo[index][status];

        }

        // HOLDING

        else{
            int sell =  prices[index] + bottomUp(index + 2, 0, memo);
            int skip = bottomUp(index + 1, 1, memo);

            memo[index][status] = Math.max(sell, skip);
            return memo[index][status];
        }
    }
}
