import heapq
from collections import Counter
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = Counter(nums)

        minHeap = []
        for (key, val) in count.items():
            heapq.heappush(minHeap,tuple((val, key)))
            if len(minHeap) > k:
                heapq.heappop(minHeap)

       
        
        res = []
        for i in range(k):
            res.append(heapq.heappop(minHeap)[1])
        return res


    
        