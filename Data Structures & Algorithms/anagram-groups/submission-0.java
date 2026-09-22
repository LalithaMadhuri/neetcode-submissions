class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 1)
            return List.of(List.of(strs[0]));
        Map<String, List<String>> res = new HashMap<>();
        for(String s: strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            res.putIfAbsent(new String(charArray), new ArrayList<>());
            res.get(new String(charArray)).add(s);

        }
        return new ArrayList<>(res.values());
    }
}
