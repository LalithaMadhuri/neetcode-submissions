class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> val_to_index= new HashMap<>();
        for(int i = 0; i < nums.length; i++)
            val_to_index.put(nums[i], i);

        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(val_to_index.containsKey(diff) && val_to_index.get(diff) != i)
                return new int[]{i, val_to_index.get(diff)};
        }

        
        return new int[0];
    }
}
