/*

Longest common subsequence between 2 strings

1. Sequence that can be derived by deleting some or no elements 
2. Dont change the order of characters

2D DP

1. Overlapping subproblem

index i => index in text1
index j => index in text2

2 choices
 a) If characters are equal => Subsequence starts/extends from current indices
 b) If characters are not equal => Skip text1[i]; Skip text2[j]

 Take max of a) and b)

2. Definition of dp

i => specifies index of text1
j => specifies index of text2

dp[i][j] specifies the longest common subsequence starting from index i from text1 and from index j from text2 to the end of text1 and text2 respectively

Recurrence 

3. Base cases

i == text1.length() || j == text2.length() => return 0 as there is no subsequence remaining 



 


*/

class Solution {
    String text1;
    String text2;
    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;

        return bottomUp(0, 0, new Integer[text1.length() + 1][text2.length() + 1]);
        
    }
    private int bottomUp(int i, int j, Integer[][] memo){
        if(i == text1.length() || j == text2.length()) return 0;
        if(memo[i][j] != null) return memo[i][j];

        int equal = 0, notEqual = 0;

        if(text1.charAt(i) == text2.charAt(j)){
            memo[i][j] = 1 + bottomUp(i + 1, j + 1, memo);
        }
             

        else{
            memo[i][j] = Math.max(bottomUp(i + 1, j, memo), bottomUp(i, j + 1, memo));
        }

        return memo[i][j]; 

        
    }
}
