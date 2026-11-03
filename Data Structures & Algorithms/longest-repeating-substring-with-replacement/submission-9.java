/*

s and integer K 

AAABABB k = 1

map => {Character: count} = size = 1

XYYX
left = 0, right = 2

{X: 2, Y: 2}

maxFreq = 2

4 - 2 > 2 

AAABBC k = 1
left = 2, right = 5
{A: 1, B: 2, C: 1}
LEN = 4

5 - 3 = 1 > 1


*/

class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, maxLen = 0, maxFreq = 1;
        Map<Character, Integer> count = new HashMap<>();

        while(right < s.length()){
            count.put(s.charAt(right), count.getOrDefault(s.charAt(right), 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(s.charAt(right)));

            if(right - left + 1 - maxFreq > k){ //(min number of char replacements) > k => window size - max freq > k
                count.put(s.charAt(left), count.getOrDefault(s.charAt(left), 0) - 1);
                if(count.get(s.charAt(left)) == 0)      
                    count.remove(s.charAt(left));
                left++;
                maxFreq = count.values().stream()
                      .max(Integer::compareTo)
                      .orElse(1);

            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;

        }
        return maxLen;
        
    }

   
}
