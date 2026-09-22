class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> val_to_index= new HashMap<>();
            

        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(val_to_index.containsKey(diff))
                return new int[]{val_to_index.get(diff), i};
            val_to_index.put(nums[i], i);
        }

        
        return new int[0];
    }
}
