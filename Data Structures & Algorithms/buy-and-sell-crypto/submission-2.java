class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1)
            return 0;

        int l = 0, r = 0, profit = 0;

        while(l <= r && r < prices.length){
            if(prices[l] < prices[r]){
                profit = Math.max(profit, prices[r] - prices[l]);
            }
            else
                l = r;

            r++;
        }
        return profit;

        
    }
}
