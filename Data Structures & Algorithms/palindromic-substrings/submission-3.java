class Solution {
    public int countSubstrings(String s) {
        if(s.length() == 1)
            return s.length();

        int n = s.length(), numOfPalindromes = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int i = 0; i < n; i++)
            dp[i][i] = true;

        for(int i = 0; i < (n - 1); i++){
            dp[i][i+1] = (s.charAt(i) == s.charAt(i + 1));
            if(dp[i][i + 1]){
                numOfPalindromes++;
            }
        }

        for(int len = 3; len <= n; len++){
            for(int i = 0, j = i + len - 1; i < n && j < n; i++, j++){
                dp[i][j] = (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j));

                if(dp[i][j]){
                    numOfPalindromes++;
                }

            }

        }
        return numOfPalindromes;
        
        
    }
}
