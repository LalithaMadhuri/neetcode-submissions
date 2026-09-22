class Solution {
    public String longestPalindrome(String s) {
        String res = "";

        int ans = 0;
        int start = 0, maxLen = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for(int i=0; i < s.length(); i++){
            dp[i][i] = true;
            ans++;
        }
        

        for(int i = 0; i < s.length() - 1; i++){
            dp[i][i+1] = (s.charAt(i) == s.charAt(i + 1));
            ans = dp[i][i+1] ? ans + 1: ans;
            if(dp[i][i+1]){
                start = i;
                maxLen = 2;
            }
            
            
        }

        for(int len = 3; len <= s.length(); len++){
            for(int i = 0, j = i + len - 1; j < s.length(); i++, j++){
                dp[i][j] = (dp[i+1][j-1] && s.charAt(i) == s.charAt(j));
                ans = (dp[i][j])? ans + 1: ans;
                if(dp[i][j] && len > maxLen){
                    maxLen = Math.max(len, maxLen);
                    start = i;
                }
                

            }
        }
        return s.substring(start, start + maxLen);
        
    }
}
