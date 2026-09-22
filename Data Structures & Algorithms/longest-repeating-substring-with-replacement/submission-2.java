class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() == 1)
            return s.length();

        int left = 0, highest_freq = 0;
        int res = 0;
        Map<Character, Integer> countChars = new HashMap<>();

        for(int right = 0; right < s.length(); right++){
            countChars.put(s.charAt(right), countChars.getOrDefault(s.charAt(right), 0)+ 1);
            highest_freq = Math.max(highest_freq, countChars.get(s.charAt(right)));
        
            if((right - left + 1) - highest_freq > k){
                countChars.put(s.charAt(left), countChars.get(s.charAt(left))- 1);
                left++;
            }
            res = right - left + 1;


        }
        return res;
        
    }
}
