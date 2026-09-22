/*

s = "zxyzxyz"

output = 3 => zxy, xyz, yzx

set = <zxy>
left = 0, right = 3 and duplicate => res = Math.max(right - left, res), left = 1

pop duplicate from set => <xy>

set = <xyz> left = 1, right = 4 

TC: O(N), SC: O(maxLen)



*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty())
            return 0;

        int res = 0, left = 0, right = 0;
        Set<Character> unique = new HashSet<>();

        while(left <= right && right < s.length()){ 

            // duplicate found
            while(!unique.isEmpty() &&  unique.contains(s.charAt(right))){
                unique.remove(s.charAt(left));
                left++;
            }
                

            res = Math.max(res, right - left + 1);
            unique.add(s.charAt(right));
            right++;
        }
        return res;

        /* z x y z x y z 
        res = 
        left = 3, right = 6
        unique = [    x y z]


        */


        
    }
}
