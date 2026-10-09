class Solution {
    public int[][] merge(int[][] intervals) {
         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    List<int[]> res = new ArrayList<>();


    for(int[] interval: intervals){

      if(res.size() == 0)
      {
        res.add(interval);
        continue;

      }
      int[] lastInterval = res.get(res.size() - 1);

      if(lastInterval[1] >= interval[0]){ // overlap
        lastInterval[1] = Math.max(lastInterval[1], interval[1]); 

      }
      else
        res.add(interval);
    }
    return res.toArray(new int[res.size()][]);
        
    }
}
