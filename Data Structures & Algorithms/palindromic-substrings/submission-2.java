class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = s.length();
       
        

        for(int i = 0; i < s.length(); i++){
            dp[i][i] = true;
        }

        for(int i = 0; i < s.length() - 1; i++){
            dp[i][i+1] = (s.charAt(i) == s.charAt(i+1));
            ans = dp[i][i+1] ? ans + 1: ans;
        }

        for(int len = 3; len <= s.length(); len++){
            for(int i = 0, j = i + len - 1; j < s.length();i++, j++){
                dp[i][j] = (dp[i+1][j-1] && s.charAt(i) == s.charAt(j));
                ans = dp[i][j] ? ans + 1: ans;
                
            }
        }
        return ans;
        
    }
}
