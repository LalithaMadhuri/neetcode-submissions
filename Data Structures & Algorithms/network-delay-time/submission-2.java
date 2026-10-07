/*

n nodes => 1 to n

[u, v, t]

1. Minimum time it takes for all nodes to receive signal starting from node 'k'

1. Pattern - Dijsktra
    Because we're trying to find the shortest time it takes for signals to be received by all nodes

    From node 'k' to
        node '1': min time
        node '2': min time
        node '3': min time
        ....
        node 'k - 1': min time

2. Idea

    times serves as adj list
    minHeap to store (Node, minTime)
    time[x] => represents the min time taken from source to current node x
        time[X] = time[current] + weight(current, X); where current is current node being processed from source(one of the hops from source) to reach X


*/


class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] time = new int[n + 1];
        Queue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(),b.getValue()));  

       Map<Integer, List<Pair<Integer, Integer>>> adjMap = new HashMap<>();

        for(int i = 0; i < times.length; i++){
            List<Pair<Integer, Integer>> neighbors = adjMap.computeIfAbsent(times[i][0],a->new ArrayList<>());
            neighbors.add(new Pair<>(times[i][1], times[i][2]));
        }

        System.out.println(adjMap);

        for(int i = 1; i <= n; i++){
            if(i == k){
                time[i] = 0;
                minHeap.offer(new Pair<>(i, 0));
            }
            else
                time[i] = Integer.MAX_VALUE;

        }

        while(!minHeap.isEmpty()){
            Pair<Integer, Integer> ele = minHeap.poll();

            if(ele.getValue() > time[ele.getKey()])
                continue;

            List<Pair<Integer, Integer>> neighbors = adjMap.get(ele.getKey());
            if(neighbors != null){
                for(Pair<Integer, Integer> nei: neighbors){
                    int minTime = time[ele.getKey()] + nei.getValue();
                    if(minTime >= time[nei.getKey()]) continue;
                    time[nei.getKey()] = minTime;
                    minHeap.offer(new Pair<>(nei.getKey(), time[nei.getKey()]));
                }
            }
               
        }

        int res = 0;
        for(int i = 1; i <= n; i++){
            if(time[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res,time[i]);

        }
        return res;
             
    }
}
