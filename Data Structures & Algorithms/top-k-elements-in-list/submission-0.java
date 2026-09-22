class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count_of_num = new HashMap<>();

        for(int num: nums){
            count_of_num.put(num, count_of_num.getOrDefault(num, 0) + 1);
        }

        System.out.println(count_of_num);
        // sort the map based on values
        List<int[]> tuples = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: count_of_num.entrySet()){
            tuples.add(new int[] {entry.getKey(), entry.getValue()});
        }

        tuples.sort((a,b) -> b[1] - a[1]);
        
        int[] res = new int[k];

        for(int i = 0; i <  k; i++){
            res[i] = tuples.get(i)[0];
        }
        return res;
        
        
        
    }
}
