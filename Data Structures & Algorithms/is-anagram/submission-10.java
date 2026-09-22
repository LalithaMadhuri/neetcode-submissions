class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character, Integer> s_map = new HashMap<>();
        Map<Character, Integer> t_map = new HashMap<>();

        int[] count = new int[26];
        

        for(int i=0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;

            // s_map.put(s.charAt(i), s_map.getOrDefault(s.charAt(i), 0) + 1);
            // t_map.put(t.charAt(i), t_map.getOrDefault(t.charAt(i), 0) + 1);

        }
        
        for(int c: count){
            if(c != 0)
                return false;
        }
        return true;

        // if(s_arr.equals(t_arr))
        //     return true;
        // else
        //     return false;



    }
}
