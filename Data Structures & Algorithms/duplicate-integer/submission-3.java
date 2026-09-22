class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums.length == 0)
            return false;

        Set<Integer> numbers = new HashSet<>();

        for(int num: nums){
            if(numbers.contains(num))
                return true;

            numbers.add(num);
        }
        return false;
        
    }
}