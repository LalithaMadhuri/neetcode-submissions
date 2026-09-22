class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

    
        Map<Character, Integer> count_chars_s = new HashMap<>();
        Map<Character, Integer> count_chars_t = new HashMap<>();
        for(int i =0; i < s.length(); i++){
            count_chars_s.put(s.charAt(i), count_chars_s.getOrDefault(s.charAt(i), 0) + 1);
            count_chars_t.put(t.charAt(i), count_chars_t.getOrDefault(t.charAt(i), 0) + 1);
        }

        if(count_chars_s.equals(count_chars_t))
            return true;
        return false;

    }
}
