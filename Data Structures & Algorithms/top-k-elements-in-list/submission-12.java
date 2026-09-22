class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();

        for(int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        //[1, 500, 500, 600, 600]
        // 1: 1, 500: 2, 600: 2 => 0 1(1) 2(500, 600)

        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            if(buckets[entry.getValue()] == null)
                buckets[entry.getValue()] = new ArrayList<>();

            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int counter = 0;

        for(int i = buckets.length - 1; i >= 0; i--){
            if(buckets[i] == null)
                continue;

            if(counter >= k)
                break;

            else if(counter < k){
                for(int freqEle: buckets[i]){
                    res[counter] = freqEle;
                    counter++;
                }
            }

        }

        return res;




        // Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        // Map<Integer, Integer> count = new HashMap<>();

        // for(int num: nums){
        //     count.put(num, count.getOrDefault(num, 0) + 1);
        // }

        // for(Map.Entry<Integer, Integer> entry: count.entrySet()){
        //     minHeap.offer(new int[]{entry.getKey(), entry.getValue()});

        //     if(minHeap.size() > k)
        //         minHeap.poll();
        // }

        // int[] res = new int[k];

        // for(int i = 0; i < k; i++){
        //     res[i] = minHeap.poll()[0];
        // }
        // return res;
        
    }
}
