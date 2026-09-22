class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    int[] state; // stores the state of the node  
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        state = new int[numCourses];

        // adjacency matrix
        for(int i =0; i<numCourses;i++)
            graph.add(new ArrayList<>());

        for(int[] pre: prerequisites){
            graph.get(pre[1]).add(pre[0]);
        }

        for(int i=0; i<numCourses; i++){

            if(!dfs(i))
                return false;
        }

        return true;
        
    }
    private boolean dfs(int cur){
        state[cur] = 1; // visiting
       
        

        for(int nei: graph.get(cur)){
            if(state[nei] == 1) // cycle
                return false;
            if(state[nei] == 0){ // unvisited
                if(!dfs(nei))
                    return false; // recurse
            }     

        }
        state[cur] = 2; // visited
        return true;

    }
}
