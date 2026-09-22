class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int value = Math.abs(nums[i]) - 1;
            if(nums[value] > 0)
                nums[value] = -nums[value];
            else
                return Math.abs(nums[i]);
        }
        return -1;
    }
}
