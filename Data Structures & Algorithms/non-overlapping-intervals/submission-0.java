/*

Return minimum number of intervals to make the input non overlapping

[[1, 2] [2, 4] [ 1, 4]] => After sorting: [[1, 2] [1, 4] [2, 4]]

Greedy algorithm 

1. Why greedy?
    Reasons
    a) Because if we select an activity which ends earlier first(best choice) it will help attend more activities

2. Idea 

    a) Sort intervals based on earliest end time
    b) Maintain a last interval = intervals[0]
    c) Loop through intervals
    d) If there is an overlap with last interval => skip
    e) Else pick it => increment number of activities





*/


class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->Integer.compare(a[1], b[1]));

        int[] lastInterval = intervals[0];
        int numActivities = 1;

        for(int i = 1; i < intervals.length; i++){
            if(lastInterval[1] > intervals[i][0]) // overlap
                continue;
            
            // select the activity
            numActivities++;
            lastInterval = intervals[i];

        }
        return numActivities == intervals.length ? 0: intervals.length - numActivities;
        
    }
}
