/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.isEmpty()) return 0;
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));


        minHeap.offer(intervals.get(0).end);

        for(int i = 1; i < intervals.size(); i++){
            System.out.println(minHeap.peek());

            if(!minHeap.isEmpty() && minHeap.peek() <= intervals.get(i).start)
                minHeap.poll();
               
             minHeap.offer(intervals.get(i).end);
        }
        return minHeap.size();

    }
}

/*

[ 15 20]


*/
