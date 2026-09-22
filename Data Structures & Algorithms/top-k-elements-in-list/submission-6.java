/*

Map: => {num: count}

Approach - 1: 

push (num,count) pairs to an array and sort it and add to res => O(NlogN) for N unique elements

SC: O(N) + O(N) = O(N)

Approach - 2: MinHeap

{1: 1, 2: 2, 3: 3} => {(1, 1) (2, 2) (3, 3)} 

TC: O(N) + O(KlogK)
SC: O(N) + O(K) + O(K)





*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        for(int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});

            if(minHeap.size() > k)
                minHeap.poll();
        }

        int[] res = new int[k];

        for(int i =0; i < k; i++){
            res[i] = minHeap.poll()[0];
        }
        return res;
        
    }
}
