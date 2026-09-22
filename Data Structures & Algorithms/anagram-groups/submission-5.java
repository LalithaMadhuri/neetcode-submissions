/*
act, pots, tops, cat, stop, hat

act: [act, cat]
tops: [pots, tops, stop]
hat: [hat]

int[26] -> string[] where each index contains equivalent of currChar - 'a' 

int[26]: {integer equivalent of curr char: [strings]}

for every string
    int[26] key
    for every character
        add char to key
    convert int[26] to string => O(L)
    check if key exists in key -> string map
    if yes -> add curr string to res else create a new key, list and add to list

return map.values as list

TC: O(N x C) + O(1) for hashmap operations where C = total number of characters in input strs
SC: O(26 x Unique Strings x Groups)


*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> keyToStr = new HashMap<>();

        for(String s: strs){
            int[] keyToInteger = new int[26];
            for(char ch: s.toCharArray())
                keyToInteger[ch - 'a']++;
            String key = Arrays.toString(keyToInteger);

            keyToStr.computeIfAbsent(key, a -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(keyToStr.values());
        
    }
}
