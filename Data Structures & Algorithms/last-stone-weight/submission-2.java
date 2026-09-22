class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1)
            return stones[0];

        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b.compareTo(a));
        for(int weight: stones)
            maxHeap.offer(weight);

        while(maxHeap.size() > 1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            if(x != y)
                maxHeap.offer(Math.abs(y - x));
        }
        return maxHeap.size() == 0? 0:maxHeap.peek();
        
    }
}
