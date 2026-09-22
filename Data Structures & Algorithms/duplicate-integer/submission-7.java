/*

Set = [1, 2, 3]

TC: O(N)
SC: O(N) worst case

If the array is sorted 

=> loop through every element and if nums[i - 1] == nums[i] => return true; else false;
O(N)



*/
class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums.length == 0)
            return false;

        Arrays.sort(nums);

        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] == nums[i])
                return true;
        }
        return false;
       
    }
}