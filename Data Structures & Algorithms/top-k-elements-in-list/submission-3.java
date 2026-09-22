class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num: nums)
            count.put(num, count.getOrDefault(num, 0) + 1);

        // place the num -> count as tuple (num, count) in a min heap
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);


        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            minHeap.offer(new int[] {entry.getKey(), entry.getValue()});
            if(minHeap.size() > k)
                minHeap.poll();
        }
            

        int[] res = new int[k];
        for(int i = 0; i < k; i++)
            res[i] = minHeap.poll()[0];

        return res;
        
    }
}
