/*

s = abcd, t = dcba => return true
s = abcd, t = dca => return false

Approach - 1: Hashmaps

1. check length of s & t
2. maintain 2 hashmaps one for each s & t
3. Track count of characters
4. check if hashmaps are equal => return true or false

Issues
1. Additional space = O(N) + O(N)
2. TC: O(1) average case for hashmap and O(N) as we're visiting every element once

Approach - 2: Constant space 

int[] array with count => a-z => 0 - 25 size 

int[26] => a = array[0]
b = array[1]..z = a[25]

First pass:
populate match[26]

Second pass:
decrement count values from match[26]

Third pass:
loop through match[26] => count != 0 => return false
return true

Adv:
Space = constant
Time = O(1) since we're looping through constant array and O(N) for looping through input array





*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] count = new int[26];

        for(char c: s.toCharArray())
            count[c - 'a']++;

        for(char c: t.toCharArray()){
            count[c - 'a']--;
            if(count[c - 'a'] < 0)
                return false;
        }
            
        return true;

    }
}
