class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> res = new HashMap<>();

        for(String s: strs){
            int[] char_arr = new int[26];

            for(char c: s.toCharArray())
                char_arr[c - 'a']++;
        
            String key = Arrays.toString(char_arr);
            if(!res.containsKey(key))
                res.put(key, new ArrayList<>());
            
            res.get(key).add(s);
            
        }
        return new ArrayList<>(res.values());
        
    }
}
