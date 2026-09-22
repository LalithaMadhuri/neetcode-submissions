class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int[] memo1 = new int[nums.length];
        int[] memo2 = new int[nums.length];
        int robFirstHouse = bottomUp(nums,0, nums.length - 2, memo1);
        int skipFirstHouse = bottomUp(nums, 1, nums.length - 1, memo2);
        return Math.max(robFirstHouse, skipFirstHouse);
        
    }
    private int bottomUp(int[] nums, int i, int end, int[] memo){
        // if(i >= nums.length)
        //     return 0;

        if(i > end) return 0;

        if(memo[i] != 0) return memo[i];

        int rob = nums[i] + bottomUp(nums, i + 2, end, memo);
        int skip = bottomUp(nums, i + 1,end, memo);
        memo[i] = Math.max(rob, skip);
        return memo[i];
    }        
 }

