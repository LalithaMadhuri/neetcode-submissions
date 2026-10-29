/*

Set = <2, 20, 4, 10, 3, 4, 5>

len = 1;
for each num
    if num < n
        continue;
    // sequence starts
    length = 1;
    n = num;
    while(set.contains(n + 1))
        length++;
        n++;
    len = Math.max(len, length)





*/

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int length = 1;
        Set<Integer> set = new HashSet<>();
        for(int num: nums)
            set.add(num);
        
        for(int num: nums){
            int len = 1, n = num;

            if(set.contains(num - 1)) continue;

            while(set.contains(n + 1)){
                len++;
                n++;

            }
            length = Math.max(len, length);

        }
        return length;
        
    }
    
}
