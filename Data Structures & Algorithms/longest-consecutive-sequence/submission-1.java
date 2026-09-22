class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>(); // contains unique ele's

        for(int num: nums)
            numSet.add(num);

        int res = 0;
        for(int num: numSet){
            if(!numSet.contains(num - 1)){ // start of a sequence
                int length = 1; // as start of sequence track length

                while(numSet.contains(num + length)) // found a consecutive ele
                    length++;

                res = Math.max(res, length);
            }
        }
        return res;
        
    }
}
