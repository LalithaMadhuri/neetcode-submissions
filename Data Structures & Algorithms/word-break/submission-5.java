/*

string = "applepenapple" dict = [apple, pen, ape]

1. Return true if string can be constructed using words in dictionary
2. A word from dict can be used any number of times

DP
1. Overlapping subproblem

   applepenapple
   a&solve(pplepenapple)
   ap&solve(plepenapple)
   app&solve(lepenapple)
   appl&solve(epenapple)
   apple&solve(penapple)....
   applepen&solve(apple)...
   applepenapple&solve("")

   a) Divide the string at index i and check if this divided piece exists in dict => returns boolean
   b) Solve for remaining string => returns boolean

   a && b => recurrence relation

2. Definition of dp

dp[i] specifies if a string from index i to end of string can be constructed using words from dictionary

3. Base case

index == string.length() => reached end of the string and no more part of string is remaining to check  => return true as empty string is always part of dictionary







*/

class Solution {
    String s;
    Set<String> words;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.words = new HashSet<String>(wordDict);
        return topDown(0, new Boolean[s.length()]);
        
    }

    private boolean topDown(int index, Boolean[] memo){
        if(index == s.length()) return true; 
        if(memo[index] != null) return memo[index];

        for(int i = index; i < s.length(); i++){
            String substr = s.substring(index, i + 1);

            if(words.contains(substr) && topDown(i + 1, memo)){
                memo[index] = true;
                return memo[index];
            }
                
        }
        memo[index] = false;
        return memo[index];

    }
}
