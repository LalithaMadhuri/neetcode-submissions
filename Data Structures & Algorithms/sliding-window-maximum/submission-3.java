/*

nums and k 

[1, 2, 1, 0, 4, 2, 6] k = 3

res = []

Queue = [1, 2, 1,]
max = 2
res = []
left = 0, right = 0

while right < nums.size()
    add (nums[right], right) to heap 

    while(!heap.isEmpty() && heap.peek().index < left)
        heap.poll();

    if(right - left + 1 == k)
        res.add(heap.peek().num);
        left++;

    
    
    right++;

return res;

(1, 0) (1, 2) (0, 3) (2, 5) (6, 6)
left = 5 right = 6
res = [2, 2, 4, 4, 6]

[1, 2, 1, 0, 4, 2, 6]

Decreasing deque

[1, 2, 1, 0, 4, 2, 6]
deque = [6]
res = [2, 2, 4, 4, 6]
left = 5, right = 6

while right < nums.length
    while(!deque.isEmpty() && deque.peekFirst() < left)
        deque.pollFirst();

    while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[right])
        deque.pollLast();
    
    deque.offerLast(right);

    if(right - left + 1 == k)
        res.add(nums[deque.peekFirst()]);
        left++;
    
    right++;

return res;
    



*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int left = 0, right = 0;

        List<Integer> res = new ArrayList<>();

        while(right < nums.length){
            while(!deque.isEmpty() && deque.peekFirst() < left)
                deque.pollFirst();
            
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[right]){
                deque.pollLast();
            }
                
            
            deque.offerLast(right);

            if(right - left + 1 == k){
                res.add(nums[deque.peekFirst()]);
                left++;
            }
            right++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
       
        // PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        // int left = 0, right = 0;
        // List<Integer> res = new ArrayList<>();

        // while(right < nums.length){
        //     maxHeap.offer(new int[]{nums[right], right});

        //     while(!maxHeap.isEmpty() && maxHeap.peek()[1] < left)
        //         maxHeap.poll();

        //     if(right - left + 1 == k){
        //         res.add(maxHeap.peek()[0]);
        //         left++;
        //     }
        //     right++;
        // }
        // return res.stream().mapToInt(Integer::intValue).toArray();
        
    }
}
