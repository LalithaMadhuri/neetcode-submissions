class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() == 1)
            return 1;

        int left = 0, maxFreqEleCount = 0, res = 0;
        Map<Character, Integer> count = new HashMap<>();
        

        for(int right = left; right < s.length(); right++){
            count.put(s.charAt(right), count.getOrDefault(s.charAt(right), 0) + 1);
            maxFreqEleCount = Math.max(maxFreqEleCount, count.get(s.charAt(right)));
            
            if((right - left + 1) - maxFreqEleCount > k){
                res = Math.max(res, right - left + 1);
                count.put(s.charAt(left), count.getOrDefault(s.charAt(left), 0) - 1);
                left++;

            }

        
            res = right - left + 1;

        }
        return res;
        
    }
}
