/*

nums = [2, 20, 4, 10, 3, 4, 5]

1. Length of longest consecutive sequence
2. Need not necessarily be contiguous


set = {2, 20, 4, 10, 3, 4, 5}

for each num in nums:
    len = 1;
    if(num - 1) not in set
        while (num + 1) in set
            len++;
            num = num + 1
        maxLen = Math.max(maxLen, len)





*/
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length < 2)
            return nums.length;
        
        Set<Integer> exists = new HashSet<>();

        for(int num: nums)
            exists.add(num);

        int maxLen = Integer.MIN_VALUE;

        for(int num: nums){
            if(!exists.contains(num - 1)){
                int curr = num, len = 1;
                while(exists.contains(curr + 1)){
                    len++;
                    curr++;

                }
                maxLen = Math.max(maxLen, len);
            }

        }
        return maxLen;
        
    }
}
