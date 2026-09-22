class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    int[] state;
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int i =0; i<numCourses; i++)
            graph.add(new ArrayList<>());

        for(int[] pre: prerequisites){
            graph.get(pre[1]).add(pre[0]);

        }

        state = new int[numCourses];

        for(int i=0; i< numCourses; i++){
            if(!dfs(i))
                return false;
        }
        return true;

        
    }

    private boolean dfs(int cur){
        state[cur] = 1; // visiting

        // visit neighbors
        for(int i: graph.get(cur)){
            if(state[i] == 1) // cycle found
                return false;

            if(state[i] == 0){
                if(!dfs(i))
                return false;
            }
            

        }
        state[cur] = 2; // visited
        return true;

    }
}
