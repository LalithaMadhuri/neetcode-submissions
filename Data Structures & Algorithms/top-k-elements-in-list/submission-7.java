/*

nums = [1, 2, 2, 3, 3, 3] , k = 2

{1:1, 2: 2, 3: 3} => [2, 3]

Maintain hashmap to track count

Approach-1: Sort hashmap 

Issue: Sorting takes O(N log N) worst case if all elements are unique

Approach-2: Min heap/Priority Queue

{(2, 2) (3, 3)} 

Time = O(N log K) but in worst case if K == N => O(N log N)

Approach-3: Bucket sort

{(2, 2) (1, 1) (3, 3)}

Buckets -> 
1. Initialize a List[] where index of bucket specifies frequency and List specifies the elements with that frequency and 
2. start reading from the end of the List[] to fetch elements with highest frequency




*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k > nums.length)
            return new int[]{};

        Map<Integer, Integer> count = new HashMap<>();

        for(int num: nums)
            count.put(num, count.getOrDefault(num, 0) + 1);

        List<Integer>[] buckets = new List[nums.length + 1];

        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
    
            if(buckets[entry.getValue()] == null)
                buckets[entry.getValue()] = new ArrayList<>();
            
            buckets[entry.getValue()].add(entry.getKey());
    
        }

        int[] res = new int[k];
        int counter = 0;

        for(int i = buckets.length - 1; i >= 0 && counter < k; i--){
            if(buckets[i] == null)
                continue;
            for(Integer ele: buckets[i])
            {
                res[counter] = ele;
                counter++; 
            }
        }
        return res;
        
    }
}
