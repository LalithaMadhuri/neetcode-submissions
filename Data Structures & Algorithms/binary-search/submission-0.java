/*

As input nums is sorted use Binary Search

maintain left = 0; right = nums.length - 1

calculat mid = left - (right - left)/2

check if mid == target => return index mid

if nums[mid] > target => mid--
else mid++

TC: O(logn)
SC: o(1)



*/

class Solution {
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
                
        }
        return -1;

        
    }
}
