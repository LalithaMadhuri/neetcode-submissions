/*

nums= [1, 2, 3, 6] target = 5
{i, j} => {1,2} 

once result is found => return it

Approach-1: Brute force

loop from index1 => index to n
    loop from index2 => index + 1 to n
        arr[index1] + arr[index2] == target

Issues:
1. Visiting an element more than once
2. Additional time => O(N^N) = worse case if index1 and index2 are at end

Approach-2: HashMap
Hashmap => {Element: Index} to keep track of already visited elements

nums[i] + nums[j] == target => check if target - nums[currIndex] in hashmap

{1: 0, 2: 1} 

5 - 3 = 2 in hashmap => Yes! => return indices

TC: O(N) as we loop through input array
SC: O(N) worst case if pair is at end of the array

*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visited = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(visited.containsKey(target - nums[i]))
                return new int[]{visited.get(target - nums[i]), i};
            visited.put(nums[i], i);
        }
        return new int[]{};

        
    }
}
