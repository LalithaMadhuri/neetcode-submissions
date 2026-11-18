"""
nums = [2, 20, 4, 10, 3, 4, 5]

convert nums to set = {2, 20, 4, 10, 3, 5}

if num in set 
    continue
if num - 1 or num + 1 in set 
    not start of a sequence
else 
    start of a sequence
    repeatedly check if num + 1 in set 
        track maxLen

maxLen = 1
for each num
    if num or num -1 or num + 1 in set
        continue
    else
        n = num
        len = 1
        while n + 1 in set
            len++
            maxLen = max(maxLen, len)
            n++
return maxLen

len = 4





"""
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        maxLen = 1
        unique = set()
        for num in nums:
            unique.add(num)

        for i in range(len(nums)):
            if nums[i] - 1 in unique:
                continue
            else:
                length = 1
                n = nums[i]
                while (n + 1) in unique:
                    length += 1
                    maxLen = max(maxLen, length)
                    n += 1
        return maxLen


        