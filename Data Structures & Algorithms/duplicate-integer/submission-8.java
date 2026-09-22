/*

nums = [1, 2, 2, 3]
output = true

Approach - 1: 

index1 = 0, index2 = 1
index1 = 1, index2 = 2 => break loop return true

if no duplicate was found => return false after entire array has been visited

issue: 
1. visiting an element more than once
2. TC: O(N^N) worst case if duplicate elements are at the end or if there are no duplicates, SC: O(1)


Approach- 2: 

Hashmap => every element is exactly visited once

{1: 1, 2: 1, 3: 2} 

return true if the count of an element > 1

an element is visited exactly once

TC: O(1) average case, SC: O(N) if duplicate if duplicate elements are at the end or if there are no duplicates

Approach-3: 
 Hashset 

Approach-4: 



*/
class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums.length == 0)
            return false;

        Set<Integer> visited = new HashSet<>();
        for(int num: nums){
            if(!visited.add(num))
                return true;
        }
        return false;
        
        
    }
}