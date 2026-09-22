/*

Frequency map=> {element: count}

Bucket Sort 

1. Initialize buckets with frequency
2. Place elements in their respective bucket based on freq
3. Loop bucket from end
4. Place each element in result list

TC: loop through input array exactly once => 0(N)
SC: Buckets => O(N) worst case


*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k > nums.length)
            return new int[]{};

        Map<Integer, Integer> frequency = new HashMap<>();

        for(int num: nums)
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);

        List<Integer>[] buckets = new List[nums.length + 1];

        for(Map.Entry<Integer, Integer> entry: frequency.entrySet()){
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
