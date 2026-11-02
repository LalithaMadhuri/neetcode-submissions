/*

buy and sell stock 
prices = [7, 1, 5, 3, 6, 4]

Output: 5


left = 0, right = 1

1. Start iterating from right = 0 
    if you find a lower price to buy => nums[left] > nums[right]
        left = right

    profit = Math.max(profit, nums[right] - nums[left])
    right++;


*/

class Solution {
    public int maxProfit(int[] prices) {
        int left = 0, right = 0, maxProfit = 0;

        while(right < prices.length){
            if(prices[left] > prices[right])
                left = right;
            
            maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            right++;
        }
        return maxProfit;
        
    }
}
