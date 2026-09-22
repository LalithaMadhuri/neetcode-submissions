class Solution {
    public int lengthOfLIS(int[] nums) {
        return bottomUp(nums, 0, -1, new int[nums.length][nums.length + 1]);
        
    }
    private int bottomUp(int[] nums, int curr, int prev, int[][] memo){
        if(curr == nums.length) // no increasing subseq found
            return 0;
        if(memo[curr][prev + 1] != 0) return memo[curr][prev + 1];

        int res = bottomUp(nums, curr + 1, prev, memo); // recursion without considering curr ele

        if(prev == -1 || nums[curr] > nums[prev]){ // curr ele is greater than prev => increasing subseq found
            res = Math.max(res, 1 + bottomUp(nums, curr + 1, curr, memo)); // update prev to point to curr ele
        }
        memo[curr][prev + 1] = res;
        return memo[curr][prev + 1];
    }
}
