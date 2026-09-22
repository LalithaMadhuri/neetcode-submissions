class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        if(s == " ")
            return 1;
        if(s.length() == 1)
            return 1;
        
        int l=0, r= 1, max_len = 0;
        Set<Character> char_set = new HashSet<>();

        char_set.add(s.charAt(l));
        while(l <= r && r < s.length()){
            while(char_set.contains(s.charAt(r))){
                
                char_set.remove(s.charAt(l));
                // char_set.add(s.charAt(r)); // since set wont accept duplicates on line 14
                l++;

            }
            char_set.add(s.charAt(r));
            max_len = Math.max(max_len, char_set.size());
            r++;

        }
        return max_len;
    }
}
