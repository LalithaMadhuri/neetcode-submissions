/*

[act, pots, tops, cat, stop, hat]

=> [[act, cat], [pots, tops, stop], [hat]]

Approach-1:
1. Sort each string
2. Store sorted string -> mappings

Issues
1. sorting a string takes additional time of O(Nlog N)

Approach-2: 
Maintain a hashmap : {String: [mappings]}
1. Compute {Character: Count} to hashmap
2. Check if Character-Count sorted strings are available in result map and add accordingly or create a new array
3. Return values in result map

Issues:
1. Sort resultant map computed based on characters O(N log N)

Approach-3:
1. Maintain a constant int[] which can have upto 26 values and keep track of the count
2. Convert this into a string and maintain a result map of string -> [mappings]

Adv:
1. Got rid of sorting and brought down the time to O(N)

TC: O(M x N) if there are N strings with an average length of M
SC: O(M x N) if there are N strings with an average length of M





*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for(String str: strs){
                

            int[] count = new int[26];
            for(char ch: str.toCharArray())
                count[ch - 'a']++;

            String key = Arrays.toString(count);

            List<String> mappings = res.computeIfAbsent(key, a -> new ArrayList<>());

            mappings.add(str);
        }
        return new ArrayList<>(res.values());
        
    }
}
