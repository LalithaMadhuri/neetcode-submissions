/*

Maximum profit => buy on lower end : sell on higher end else 0

prices = [10,1,5,6,7,1] 

left = 0, right = 5 => for 10 dint find any price > 10
if you buy on 10 => can you sell on any higher rate
buy 1 = sell 7 => profit = 6 left = 1, right = 4
buy 1 = sell 6 => profit = 5 left = 1, right = 3
buy 1 = sell 5 => profit = 4 left = 1, right = 2
buy 5 = sell 7 => profit 2 left = 2, right = 4
buy 5 = sell 6 => profit = 1 left = 2, right = 3
buy 6 = sell 7 => profit = 1 left = 3, right = 4

pattern => sell > buy 

For every price on the left ; find a right where price[right] > price[left] 
and calculate profit
if(price[left] > price[right]) => left++

left keeps track of cheapest buying price found so far for a price at right

right keeps track of current selling price

TC: O(N)
SC: O(1)





*/

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, left = 0, right = 0;

        while(right < prices.length){
            
            if(prices[left] > prices[right]){
                left = right; // found a new minimum
            }
            maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            right++;
            
        }
        return maxProfit;

        
    }
}
