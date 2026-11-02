/*

Queue = [5, 1, 5]
sum = 14
minLen = 0

for each num:
queue.offer(num)
while(!queue.isEmpty() && sum >= target)
    minLen = Math.min(minLen, queue.size())
    sum -= queue.poll();

return minLen
    

sum = 14
    minLen = 5
    sum = 12
sum = 12
    minLen = 4
    sum = 11
sum = 11
    minLen = 3
    sum = 6
sum = 6
    



*/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, minLen = Integer.MAX_VALUE;
        Queue<Integer> queue = new ArrayDeque<>();

        for(int num: nums){
            queue.offer(num);
            sum += num;

            while(!queue.isEmpty() && sum >= target){
                minLen = Math.min(minLen, queue.size());
                sum -= queue.poll();
            }
        }
        return minLen == Integer.MAX_VALUE ? 0: minLen;
        
    }
}