import heapq
from collections import Counter
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = Counter(nums)

        minHeap = []
        for (key, val) in count.items():
            heapq.heappush(minHeap,(val, key))
            if len(minHeap) > k:
                heapq.heappop(minHeap)

       
        
        return [key for (val, key) in minHeap]



    
        