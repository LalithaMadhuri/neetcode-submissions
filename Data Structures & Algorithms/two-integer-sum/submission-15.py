class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = dict()
        for i in range(len(nums)):
            if target - nums[i] in seen:
                return [seen.get(target - nums[i]), i]
            seen[nums[i]] = i
        return list()

        