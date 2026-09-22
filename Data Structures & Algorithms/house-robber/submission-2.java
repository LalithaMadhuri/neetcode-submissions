class Solution {
    public int rob(int[] nums) {
        return Math.max(bottomUp(nums, 1, new int[nums.length]), nums[0] + bottomUp(nums, 2, new int[nums.length]));
        
    }
    private int bottomUp(int[] nums, int i, int[] memo){
        if(i >= nums.length) return 0;
        if(memo[i] != 0) return memo[i];

        memo[i] = Math.max(bottomUp(nums, i+1, memo), nums[i] + bottomUp(nums, i+2, memo));

        return memo[i];
    }
}
