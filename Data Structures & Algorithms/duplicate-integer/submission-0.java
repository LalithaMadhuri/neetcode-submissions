class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums.length == 0)
            return false;
        Map<Integer, Integer> count_of_num = new HashMap<>();
        for(int num: nums){
            if(count_of_num.containsKey(num))
                return true;
            count_of_num.put(num, 1);
        }
        return false;
        
    }
}