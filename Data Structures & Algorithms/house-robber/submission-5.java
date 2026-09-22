class Solution {
    public int rob(int[] nums) {
        return bottomUp(nums, 0, new int[nums.length]);
        
    }
    private int bottomUp(int[] nums, int i, int[] memo){
        if(i >= nums.length)
            return 0;
        if(memo[i] != 0) return memo[i];

        int rob = nums[i] + bottomUp(nums, i + 2, memo);
        int skip = bottomUp(nums, i + 1, memo);
        memo[i] = Math.max(rob, skip);
        return memo[i];
    }
}
