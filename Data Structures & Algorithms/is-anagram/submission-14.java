/*

1. Check if there is mismatch in lengths => return false

Approach - 1: Maintain 2 hashmaps each of {Character: Count}
if(map1.length != map2.length) => return false
if(map1 == map2) => return true; else false

loop through s1 => add char -> count
loop through s2 => if curr char in s2 in map1 => decrement count

if(map.isEmpty() or map.size == 0) => return true
else return false;

TC: O(S1 + S2) 
SC: O(S1 + S2) => S1 = length of S1, S2 = length of S2

Approach 2: count -> char[26]; 
loop through s1 and modify count arr
loop through s2 and decrement counts in count

loop through count => if value > 0 => return false

TC: O(S1 + S2)
SC: O(1) as char[26]




*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] count = new int[26];

        for(char ch: s.toCharArray()){
            count[ch - 'a']++;
        }

        for(char ch: t.toCharArray()){
            count[ch - 'a']--;
        }

        for(int c: count){
            if(c > 0)
                return false;
        }
        return true;

        // Map<Character, Integer> count = new HashMap<>();

        // for(char ch: s.toCharArray()){
        //     count.put(ch, count.getOrDefault(ch, 0) + 1);
        // }

        // for(char c: t.toCharArray()){
        //     if(count.containsKey(c)){
        //         count.put(c, count.get(c) - 1);
        //         if(count.get(c) == 0)
        //             count.remove(c);
        //     }
                
        //     else
        //         count.put(c, 1);
        // }

        // if(count.size() == 0)
        //     return true;

        // return false;
       

    }
}
