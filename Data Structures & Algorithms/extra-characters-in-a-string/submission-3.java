/*

neetcodes [neet, code, neetcode]

DP problem

1. Overlapping problem

    neetcodes
    1. n & recurse(1, eetcodes)
        a) assume a word with n will be found in dictionary 
            ne & recurse(2, etcodes)
                a) nee & recurse(3, tcodes)
                b) length from 0 to index + e & recurse(3, tcodes)
        b) assume a word with n will NOT be found in dictionary 
            length from 0 to index + e & recurse(2, etcodes)

2. Definition of dp
    dp[i] represents the minumum number of extra characters left to break string starting at index i to end optimally

3. Base case
    if i == s.length() => return 0 as no extra characters are left o recurse







*/


class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> words = new HashSet<>();
        for(String word: dictionary)
            words.add(word);


        return topDown(0, 0, s, words, new Integer[s.length()][s.length()]);

        
    }
    private int topDown(int start, int end, String s, Set<String> words, Integer[][] memo){
        if(start >= s.length()) return 0;
        if(start > end) return 0;
        if(end >= s.length()){
            if(words.contains(s.substring(start, end)))
                return 0;
            return end - start;
        }
        if(memo[start][end] != null) return memo[start][end];

        if(words.contains(s.substring(start, end + 1))){
            memo[start][end] = Math.min(topDown(start, end + 1, s, words, memo),topDown(end + 1, end + 1, s, words, memo));
            return memo[start][end];
        } 


        memo[start][end] = Math.min(topDown(start, end + 1, s, words, memo), (end - start + 1) + topDown(end + 1, end + 1, s, words, memo));
        return  memo[start][end];
    }
}