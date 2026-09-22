class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1)
            return s;

        int start = 0, maxLen = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for(int i=0; i < s.length(); i++){
            dp[i][i] = true;

        }

        for(int i = 0; i < s.length() - 1; i++){
            dp[i][i+1] = (s.charAt(i) == s.charAt(i+1));
            if(dp[i][i+1]){
                maxLen = 2;
                start = i;
            }
        }

        for(int len = 3; len <= s.length(); len++){
            for(int i=0, j = i +len -1; j < s.length(); i++, j++){
                dp[i][j] = (dp[i+1][j-1] && s.charAt(i) == s.charAt(j));
                if(dp[i][j] && len > maxLen){
                    maxLen = Math.max(len, maxLen);
                    start = i;
                }
            }
        }
        return s.substring(start, start+maxLen);
        
    }
}
