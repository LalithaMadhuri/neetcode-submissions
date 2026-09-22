class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;

        Map<Integer, Integer> length_subseq = new HashMap<>();
        int res = 0;
        
        for(int num: nums){
            if(length_subseq.containsKey(num))
                continue;
            
            // update length of current num using left and right subseq
            length_subseq.put(num, length_subseq.getOrDefault(num - 1, 0) + length_subseq.getOrDefault(num + 1, 0) + 1);
            // update left boundary length 
            length_subseq.put(num - length_subseq.getOrDefault(num - 1, 0), length_subseq.get(num));
            // update right boundary length
            length_subseq.put(num + length_subseq.getOrDefault(num + 1, 0), length_subseq.get(num));
            // update res with longest subseq
            res = Math.max(res, length_subseq.get(num));

        }
        return res;
        

        
        
    }
}
