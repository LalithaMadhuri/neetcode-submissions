class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(numToIndex.containsKey(target - nums[i]))
                return new int[]{numToIndex.get(target - nums[i]), i};
            numToIndex.put(nums[i], i);
        }
        return new int[]{};
    }
}
