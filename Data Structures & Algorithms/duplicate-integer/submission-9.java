class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>();

        for(int num: nums){
            if(!unique.add(num))
                return true;
        }
        return false;
        
    }
}