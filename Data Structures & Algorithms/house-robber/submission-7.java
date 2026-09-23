/*

amounts = [1, 1, 3, 3]

1. Cannot rob adjacent houses
2. Maximum amount of money 

DP
1. Optimal substructure
 
 2 choices 
 a) Rob the house 
 b) skip the house 

 a) Rob => amount[i] + move to (i + 2) house as (i + 1) house can't be robbed
 b) Skip => move to (i + 1) house

 Take max of (a) and (b)

 2. What state does dp maintain?

Dp maintains maximum amount robbed from ith house to the end

3. Base case

index >= nums.length => return 0 as no additional amount can be robbed


  



*/

class Solution {
    public int rob(int[] nums) {
        return bottomUp(nums, 0, new int[nums.length + 1]);
        
    }
    private int bottomUp(int[] nums, int index, int[] memo){
        if(index >= nums.length) return 0;
        if(memo[index] != 0) return memo[index];

        /*
        1. Skip current index house and move to index + 1 house
        2. Rob current house and move to index + 2 house as index + 1 house can't be robbed

        */
        memo[index] = Math.max(bottomUp(nums, index + 1, memo), nums[index] + bottomUp(nums, index + 2, memo)); 
        return memo[index]; 
    }
}
