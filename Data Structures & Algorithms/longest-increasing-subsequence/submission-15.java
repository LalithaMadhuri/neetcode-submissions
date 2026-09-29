/*

nums = [9, 1, 4, 2, 3, 3, 7]

1. Strictly Increasing Subsequence
2. Longest length of increasing subsequence

Kadane's algorithm

DP

1. Optimal substructure

2 choices
a) extend from previous sequence => if curr element > prev element observed
b) start from current element => if curr element <= prev element

Choose Max of option a) and b)

2. Definition of dp

dp[i] represents the max length of the subsequence starting from index i to end of input array

3. Base case

index == nums.length => reached end of array no more subsequence => no mor elength to calculate => return 0


*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++)
            maxLen = Math.max(maxLen, bottomUp(nums, i, memo));
        return maxLen;
        
    }

    private int bottomUp(int[] nums, int index, Integer[] memo){
        if(index == nums.length) return 0;
        if(memo[index] != null) return memo[index];

        int maxLen = 1;

        // consider num[index]
        for(int j = index + 1; j < nums.length; j++){
            if(nums[index] < nums[j])
            {
                maxLen = Math.max(maxLen, 1 + bottomUp(nums, j, memo));
        
            }

        }
        memo[index] = maxLen;
        return memo[index];
    }
}
