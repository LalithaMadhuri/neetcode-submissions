class Solution {
    public boolean isAnagram(String s, String t) {
        boolean res;
        Map<Character, Integer> count_chars_s = new HashMap<>();
        for(char c: s.toCharArray()){
            count_chars_s.put(c, count_chars_s.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> count_chars_t = new HashMap<>();
        for(char c: t.toCharArray()){
            count_chars_t.put(c, count_chars_t.getOrDefault(c, 0) + 1);
        }

        if(count_chars_s.equals(count_chars_t))
            return true;
        return false;

    }
}
