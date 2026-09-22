/*

XYYX , K = 2 =>output = 4

AAABABB, K = 1=> output = 5

{X: 4} , K = 0

{A: 5, B: 1} K = 0

Maintain 2 pointers left and right => left = 0, right = 0

Map: {Character: count}


Sliding window

left = 0, right = 0, k = 1, input = AAABABB. {A: 2, B: 2} 5 - 3 > 2, l = 3, r = 5

while left < right

    while((right - left + 1) - maxFreq > k)
    {
        left++;
        map.put(s[left], s[left] - 1);
    }

    maxFreq = Math.max(maxFreq,right - left + 1)
    map.put(s[right], .get(s[right] + 1));
    right++;

return maxFreq





*/

class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();

        int left = 0, right = 0, res = 0, maxFreqCount = 0;

        while(left <= right && right < s.length()){

            count.put(s.charAt(right),count.getOrDefault(s.charAt(right), 0) + 1);
            maxFreqCount = Math.max(maxFreqCount, count.get(s.charAt(right)));

            while((right - left + 1) - maxFreqCount > k){
                count.put(s.charAt(left),count.get(s.charAt(left)) - 1);
                left++;
                
            }

            res = Math.max(res, right - left + 1);
            right++;

        }
        return res;
        
    }
}
