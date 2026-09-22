class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramToGroup = new HashMap<>();

        for(String str: strs){
            int[] count = new int[26];

            for(char ch: str.toCharArray())
                count[ch - 'a']++;

            List<String> group = anagramToGroup.computeIfAbsent(Arrays.toString(count), a -> new ArrayList<>());

            group.add(str);
        }
        return new ArrayList<>(anagramToGroup.values());
        
    }
}
