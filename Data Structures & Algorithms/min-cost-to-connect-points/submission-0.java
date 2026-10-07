/*

Connect ALL points together or cheapest edges that expand a growing component and connects all nodes

A point can potentially connect to all the points or nodes

1. Pattern - Prim's algorithm
    Why? 
        As we're trying to find cheapest edge to grow connected component and eventually connect all the nodes


2. Idea

    Manhattan distance = dist

    Visited = Set(), minHeap = [(Node, dist)]

    minHeap.add(((0, 0)))


    minCost = 0;
    numNodes = 0;
    while heap is not empty
        pop element

        if(numNodes == points.size()) return minCost;

        if(element[0] is visited) continue;

        numNodes++;

        mark element[0] as visited

        minCost += element[1]

        get remaining nodes(all nodes except element[0])
            dist = manhattan distance between node and element[0]
            push (node, dist) to heap
    return minCost;






*/

class Solution {
    public int minCostConnectPoints(int[][] points) {

        Set<Integer> visited = new HashSet<>();
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[3], b[3]));

        minHeap.offer(new int[]{points[0][0], points[0][1], 0, 0});

        int minCost = 0;

        while(!minHeap.isEmpty()){
            int[] ele = minHeap.poll();
            int x = ele[0], y = ele[1], index = ele[2], dist = ele[3];

            if(visited.contains(index)) continue;

            visited.add(index);
            minCost += dist;

            if(visited.size() == points.length) return minCost;

            for(int i = 0; i < points.length; i++){
                if(i == index) continue;
                
                int manhattanDist = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                minHeap.offer(new int[]{points[i][0], points[i][1], i,manhattanDist});
                
            }


        }
        return minCost;
        
    }
}
