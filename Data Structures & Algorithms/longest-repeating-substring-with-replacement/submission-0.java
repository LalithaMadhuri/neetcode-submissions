class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() == 1)
            return 1;

        int l=0, res = 0, highest_freq = 0;
        Map<Character, Integer> count = new HashMap<>();

        // expand the window
        for(int r = 0; r < s.length(); r++){
            // increment the count
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            // update highest frequency
            highest_freq = Math.max(highest_freq, count.get(s.charAt(r)));

            // condition where window becomes invalid
            if((r - l + 1) - highest_freq > k){
                // decrement the count 
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }
            res = (r - l + 1);

        }
        return res;
        
        
    }
}
