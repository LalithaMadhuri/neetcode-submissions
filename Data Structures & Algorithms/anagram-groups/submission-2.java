class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 1)
            return List.of(List.of(strs[0]));
        Map<String, List<String>> res = new HashMap<>();
        for(String s: strs){
            int[] char_to_int = new int[26];

            char[] charArray = s.toCharArray();
            for(char c: charArray)
                char_to_int[c - 'a'] += 1;
            
            res.putIfAbsent(Arrays.toString(char_to_int), new ArrayList<>());
            res.get(Arrays.toString(char_to_int)).add(s);

        }
        return new ArrayList<>(res.values());
    }
}
