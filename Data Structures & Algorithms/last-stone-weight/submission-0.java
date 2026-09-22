class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1)
            return stones[0];

        int res = 0, k = 2;

        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b.compareTo(a));

        for(int weight: stones){
            maxHeap.add(weight);
        }
            

        


        while(maxHeap.size() > 1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            System.out.println(x);
            System.out.println(y);


            maxHeap.add(Math.abs(y - x));

        }
        return maxHeap.size() > 0 ? maxHeap.peek(): 0;
        
    }
}
