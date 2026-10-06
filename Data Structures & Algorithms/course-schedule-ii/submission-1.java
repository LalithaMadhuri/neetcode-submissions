/*

adjList = [[] [0] []]

visiting = <0>, completed = <0>


*/

class Solution {
    List<Integer> res;
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Set<Integer> visiting = new HashSet<>();
        Set<Integer> completed = new HashSet<>();
        this.res = new ArrayList<>();

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            List<Integer> list = adjList.get(prerequisites[i][0]);
            list.add(prerequisites[i][1]);
        }

    

        for(int i = 0; i < numCourses; i++){
            if(!completed.contains(i)){
                if(!dfs(i, adjList.get(i), visiting, completed, adjList))
                    return new int[]{};
            }
        }
        return res.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
        
    }

    private boolean dfs(int index, List<Integer> prereqList, Set<Integer> visiting, Set<Integer> completed, List<List<Integer>> adjList){
        if(visiting.contains(index)) return false;

        visiting.add(index);

        for(int course: prereqList){
            if(!completed.contains(course)){
                if(!dfs(course, adjList.get(course), visiting, completed, adjList))
                    return false;
            }
        }

        
        visiting.remove(index);
        completed.add(index);
        res.add(index);
        
        return true;
    }
}
