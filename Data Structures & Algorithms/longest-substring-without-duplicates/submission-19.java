/*

pwwkew => 3 

Longest substring without repeating characters 

Set = <w k e>
left = 2, right = 5

while right < s.length()
    while !set.isEmpty() && set.contains(s.charAt(right))
        set.remove(s.charAt(left));
        left++;

    set.add(s.charAt(right));
    len = Math.max(len, right - left + 1);

    right++;

return len;





*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        int left = 0, right = 0;
        Set<Character> exists = new HashSet<>();
        int len = 0;

        while(right < s.length()){
            while(!exists.isEmpty() && exists.contains(s.charAt(right))){
                exists.remove(s.charAt(left));
                left++;
            }
            exists.add(s.charAt(right));
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
        
    }
}
