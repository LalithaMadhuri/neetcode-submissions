class Solution {
    public int lengthOfLIS(int[] nums) {
        return bottomUp(nums, 0, -1, new int[nums.length][nums.length + 1]);
        
        
    }
    private int bottomUp(int[] nums, int curr, int prev, int[][] memo){
        if(curr == nums.length)
            return 0;

        if(memo[curr][prev + 1] != 0) return memo[curr][prev +1];

        int res = bottomUp(nums, curr + 1, prev, memo); // move forward

        if(prev == -1 || nums[curr] > nums[prev]) // select curr element
            res = Math.max(res, 1 + bottomUp(nums, curr + 1, curr, memo)); // keep track of max length found till now

        memo[curr][prev + 1] = res;

        return res;

    }
}
