/*

non overlapping intervals 

sorted based on start time

newInterval 

1. High level Idea

1. Compare currentInterval with newInterval using the following logic 

    if currentInterval.start < newInterval.start
        compare current interval with new interval
    else
        compare newInterval with current interval

    a) if there's an overlap with newInterval => merge it into newInterval 
    b) if there's no overlap -> 
     (i) add current interval OR
     (ii) new interval based on the logic determined before (a) 
            add current interval after adding newInterval 
    

3. Add newInterval to res

     Input: intervals = [[1,2],[3,5],[9,10]], newInterval = [6,7]

    res = [[1, 2] [3, 5] [6, 7] [9, 10]]


intervals = [[1,2], [3,5], [6,7], [8,10], [12,16]]
newInterval = [3,10]

 res = [[1, 2] [3, 10] [12, 16]]

    [currentInterval] [newInterval] [currentInterval]

    a) currInterval.end < newInterval.start => currInterval comes before so add it to res
    b) newInterval.end < currInterval.start => newInterval comes before so add newInterval to res and keep the other intervals order as is 
    c) Overlap! Merge both currInterval and newInterval into newInterval and continue




*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        boolean isNewIntervalMerged = false;

        for(int[] currInterval: intervals){
            if(isNewIntervalMerged)
            {
                res.add(currInterval);
                continue;
            }
            if(currInterval[1] < newInterval[0])
                res.add(currInterval);

            else if(newInterval[1] < currInterval[0])
            {
                res.add(newInterval);
                res.add(currInterval);
                isNewIntervalMerged = true;
            }
            else{
                newInterval[0] = Math.min(currInterval[0], newInterval[0]);
                newInterval[1] = Math.max(currInterval[1], newInterval[1]);
            }
        

        }
        if(!isNewIntervalMerged)
            res.add(newInterval);
       
        return res.toArray(new int[0][0]);
        
    }
}
