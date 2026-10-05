/*

prerequisites = [a, b] => 'b' has to be taken before 'a'
numCourses = 2 => Course 0, Course 1

C0 C1
1  Null  

C0. C1. 1 -> 0 and 0 -> 1 => cycle!
1.  0

DFS
1. Pattern - DFS
    DFS suits well here because
        a) it detects if there is a cycle

2. Definition of DFS
    dfs() represents if a course i can be completed or not

3. High level idea 
    1. Build an adjacency list 
        a) each index represnts course
        b) value represents prerequisite

    2. Explore each path 
        a) currently visiting set => nodes exploring current path
        b) visited set => nodes that completed exploring a given path

     If same node appears again while visiting current path => there is a cycle and return false



4. Base case
    node in visiting set => return false
    reached end or list is empty => add to completed set, remove from visiting and return true


  for each index in adj list
        if(index not in completed)
            dfs(index, prereqList)

    dfs(index, prereqList):
        
        if(prereqList is empty)
            add index to completed
            remove index from visiting
            return true

        add index to visiting
        for each pre of list[prereq]:
            if(pre in visiting) return false;
            if(pre not in completed)
                boolen isCompleted =  dfs(pre, adjlist[pre])
                if(!isCompleted) return false;

        add index to completed
        remove index from visiting
        return true
        return true;

visiting = <>, completed = <0, 1, 2,3 >
dfs(3, 2) => 


prerequisites = [[3,0], [3,1], [3,2]]
adjacency list = [[] [] [] [2,1,0]]




*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // if(numCourses == 1)
        //     return false;

        int m = prerequisites.length;
        List<List<Integer>> adjList = new ArrayList<>();

        Set<Integer> visiting = new HashSet<>();
        Set<Integer> completed = new HashSet<>();

        
        for(int i = 0; i < numCourses; i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            List<Integer> list = adjList.get(prerequisites[i][0]);
            list.add(prerequisites[i][1]);  
            
        }

        for(int k = 0; k < numCourses; k++){
            if(!completed.contains(k))
            {
                if(!dfs(k, adjList.get(k), visiting, completed, adjList))
                    return false;
            }

        }
        return true;


        
    }

    private boolean dfs(int index, List<Integer> prereqList, Set<Integer> visiting, Set<Integer> completed, List<List<Integer>> adjList){
        if(visiting.contains(index)) return false;
        // if(prereqList.isEmpty()){
        //     visiting.remove(index);
        //     completed.add(index);
        //     return true;

        visiting.add(index);

        for(int course: prereqList){
            if(!completed.contains(course))
            {
                if(!dfs(course, adjList.get(course), visiting, completed, adjList))
                    return false;
            }
        }

        visiting.remove(index);
        completed.add(index);
        return true;


    }
}
