class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a,b)-> (b[1] - a[1])); // num -> count

        Map<Integer, Integer> count = new HashMap<>();
        for(int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            maxHeap.offer(new int[]{entry.getKey().intValue(), entry.getValue().intValue()});
        }

        int[] res = new int[k];

        for(int i = 0; i<k; i++){
            res[i] = maxHeap.poll()[0];
        }
        return res;
        
    }
}
