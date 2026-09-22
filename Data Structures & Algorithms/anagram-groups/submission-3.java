class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> res = new HashMap<>();

        for(String s: strs){
            int[] key = new int[26];

            for(char c: s.toCharArray())
                key[c - 'a']++;
        
            if(!res.containsKey(Arrays.toString(key)))
                res.put(Arrays.toString(key), new ArrayList<>());
            
            res.get(Arrays.toString(key)).add(s);
            
        }
        return new ArrayList<>(res.values());
        
    }
}
