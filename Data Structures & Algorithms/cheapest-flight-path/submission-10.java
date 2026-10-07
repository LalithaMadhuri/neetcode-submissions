/*

Directed graph 

flights = [from airport, to airport, price]

src -> dest; k = maximum number of stops excluding src and dest

1. Return cheapest price from src to dest or -1 if impossible

1. Problem - Dijsktra
    Since we have to return cheapest/minimum price from src to destination

2. Idea
    Keep track of minimum distance from src to a given node 
    Keep track of number of stops as well

    1 node to 2 node, k = 1

    node 0 -> INF
    node 1 -> 0
    node 2 -> INF
    node 3 -> INF 

    Min heap = [(1, 0, 0) (0, 100, 1) (2, 200, 1)  ]

    if queue is not empty
        pop element from queue 

        if(element[0] == dst) price[dst] = element[1]; break;

        if(element[2] > k) continue;

    
        for each neighbor of element[0]
            int pr = element[0] + weight(element[0], neighbor)
            if(pr > price[neighbor]) continue;

            if(element[0] == src) stops = 0;
            else stops = element[2] + 1;

            if(neighbor == dst || stops <= k)
                price[neighbor] = pr;
                add (neighbor, price[neighbor],stops) to heap


*/

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<int[]>> adjMap = new HashMap<>();
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int[][] price = new int[n][k + 1];
        for(int[] row: price)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        for(int i = 0; i < flights.length; i++){
            List<int[]> neighbors = adjMap.computeIfAbsent(flights[i][0],a-> new ArrayList<>());
            neighbors.add(new int[]{flights[i][1], flights[i][2]});
        }

        price[src][0] = 0;
        minHeap.offer(new int[]{src, 0, 0});

        while(!minHeap.isEmpty()){
            int[] ele = minHeap.poll();
            int currNode = ele[0], currPrice = ele[1], currStops = ele[2];

            if(currStops > k) continue;

            if(currNode == dst){
                return price[dst][currStops];
                // price[dst][currStops] = Math.min(price[dst][currStops],currPrice);
                // break;
            }

        
            List<int[]> neighbors = adjMap.get(currNode);

            if(neighbors != null){
                for(int[] nei: neighbors){
                    int neiNode = nei[0], neiPrice = nei[1];
                    int pr = currPrice + neiPrice;

                    int stops =  currNode == src ? 0: currStops + 1;
                    
                    if(stops <= k)
                    {
                        if(pr >= price[neiNode][stops]) continue;
                        price[neiNode][stops] = pr;
                        minHeap.offer(new int[]{neiNode, price[neiNode][stops],stops});
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;

        for(int i =0; i <= k; i++){
            res = Math.min(res, price[dst][i]);
        }
            

        return -1;



    }
}
