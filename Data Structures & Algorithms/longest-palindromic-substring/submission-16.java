/*

String s

1. longest palindromic substring of s
2. A single character is itself a palindrome

DP
1. Optimal substructure

Solve problem from smaller subproblems

Check for 1 length palindromes
Check for 2 length palindromes 

Use these 2 to check for 3 length palindromes

Essentially, dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j]



2. Definition of dp and what it stores

2D boolean array to-
a) Specify if there's a palindrome between indices (i, j)


1 length palindromes-
dp[0][0], dp[1][1]..dp[i][i] are 1 length palindromes

2 length palindromes - 
dp[i][i + 1] is a palindrome if s[i] == s[i + 1] 

abbc => dp[1][2] = true

3 length palindromes -


dp[i][j] where j - i == 3 => dp[i + 1][j - 1] == palindrome && s[i] == s[j]


Example : 

abba =>

dp[0][0] = true....dp[3][3] = true

dp[0][1] = false
dp[1][2] = true
dp[2][3] = false

dp[0][2] = false => dp[1][1] && s[i] == s[j]
dp[1][3] = false

dp[0][3] => dp[1][2] && s[0] == s[3]

3. Base condition

length 1 palindrome
length 2 palindrome

Calculate longest palindrome 

start, end 



*/
class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1)
            return s;

        int n = s.length(), start = 0, end = 0, maxLength = 1;
        boolean[][] dp = new boolean[n][n];

        for(int i = 0; i < n; i++)
            dp[i][i] = true;

        for(int i = 0; i < (n - 1); i++){
            dp[i][i+1] = (s.charAt(i) == s.charAt(i + 1));
            if(dp[i][i + 1] && maxLength < 2){
                start = i;
                maxLength = 2;
            }
        }

        for(int len = 3; len <= n; len++){
            for(int i = 0, j = i + len - 1; i < n && j < n; i++, j++){
                dp[i][j] = (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j));

                if(dp[i][j] && maxLength < (j - i + 1)){
                    start = i;
                    maxLength = j - i + 1;
                }

            }

        }
        return s.substring(start, start + maxLength);
        
    }
}
