class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        int[] memo1 = new int[nums.length];
        int[] memo2 = new int[nums.length];

        int includeFirstHouse = bottomUp(nums, 0, nums.length - 2, memo1);
        int excludeFirstHouse = bottomUp(nums, 1, nums.length - 1, memo2);


        return Math.max(includeFirstHouse, excludeFirstHouse);
        
    }
    private int bottomUp(int[] nums, int i, int end, int[] memo){
        //if(i >= nums.length) return 0;
        if(i > end) return 0;
        if(memo[i] != 0) return memo[i];

        memo[i] = Math.max(bottomUp(nums, i+1, end, memo), nums[i] + bottomUp(nums, i+2,end, memo));

        return memo[i];
    }
}
