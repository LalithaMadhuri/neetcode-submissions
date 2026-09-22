class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num: nums)
            count.put(num, count.getOrDefault(num, 0) + 1);

        // place the num -> count as tuple (num, count) in an array
        List<int[]> tuple = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry: count.entrySet())
            tuple.add(new int[] {entry.getKey(), entry.getValue()});

        tuple.sort((a,b) -> b[1] - a[1]);

        int[] res = new int[k];
        for(int i = 0; i < k; i++)
            res[i] = tuple.get(i)[0];

        return res;
        
    }
}
