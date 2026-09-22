/*

Approach - 1: 1. Sort the input array
2. 2 pointers -> left + right to check target 

a[left] + a[right] < target => left++;
a[left] + a[right] > target => right--
a[left] + a[right] == target => return res

TC: O(NlogN)
SC: O(1)

Approach - 2: HashMap => {integer: index}

Loop through input array => if(target - currInteger in map) => return res

else => add intger, idnex to map

TC: O(N)
SC: O(N) worst case




*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(numToIndex.containsKey(target - nums[i]))
                return new int[]{numToIndex.get(target - nums[i]), i};
            numToIndex.put(nums[i], i);
    
        }
        return new int[]{};
       
        
    }
}
