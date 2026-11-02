/*

1. Window represents numbers with atleast one duplicate set of indices
2. left = 0, right = 0


nums = [1 0 1 1] k = 1

left = 2, right = 3
Set = [1]

while right < nums.length()
    while(!set.isEmpty() && (right - left + 1) > (k + 1))
        set.remove(nums[left])
        left++;

    
    if(nums[right] in set)
        return true
        
    set.add(nums[right])
        
    right++;
return false;


*/
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> exists = new HashSet<>();
        int left = 0, right = 0;

        while(right < nums.length){
            while(!exists.isEmpty() && (right - left + 1) > (k + 1)){
                exists.remove(nums[left]);
                left++;
            }

            if(exists.contains(nums[right]))
                return true;
            
            exists.add(nums[right]);
            right++;
        }
        return false;
        
    }
}