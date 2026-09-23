/*

amount = [3, 4, 3]

1. Arranged in a circle => 1st and last house are neighbors (0, nums.length - 1)
2. Can't rob from adjacent houses
3. Maximum amount of money that can be robbed

DP
1. Optimal substructure
 2 choices
 a) Rob the house => amount[i] + move to (i + 2) house
 b) Skip the house => move to (i + 1) house

 Additional condition:
 index == nums.length - 1 => next index would be 0

 (i) Rob house 0 then house n - 1 cannot be robbed
 (ii) Skip house 0 then house n - 1 can be robbed

 Take max of (i) and (ii)

 2. Definition or state of dp

 Dp would store maximum amount that can be robbed from ith house to the end of a range

 3. Base case

    Pass range of nums(nums[0:n-2] or nums[1: n-1]) mentioned in Step 1 to recursive function

    index == nums.length => return 0




*/
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        return Math.max(bottomUp(nums, 0, nums.length - 1, new int[nums.length + 1]), bottomUp(nums, 1, nums.length, new int[nums.length + 1]));

    
        
    }
    private int bottomUp(int[] nums, int start, int end, int[] memo){
        if(start >= end) return 0;
        if(memo[start] != 0) return memo[start];

        memo[start] = Math.max(bottomUp(nums, start + 1, end, memo), nums[start] + bottomUp(nums, start + 2, end, memo));

        return memo[start];
    }
}
