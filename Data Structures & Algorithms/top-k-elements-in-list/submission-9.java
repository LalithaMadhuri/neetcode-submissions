class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        Map<Integer, Integer> count = new HashMap<>();

        for(int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});

            if(minHeap.size() > k)
                minHeap.poll();
        }

        int[] res = new int[k];

        for(int i = 0; i < k; i++){
            res[i] = minHeap.poll()[0];
        }
        return res;
        
    }
}
