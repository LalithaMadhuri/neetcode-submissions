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
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        Interval last = null;
        
        for(Interval interval: intervals){
            if(last == null){
                last = interval;
                continue;
            }

            if(last.end > interval.start) // overlap
                return false;
            
            last = interval;

        }
        return true;

    }
}
