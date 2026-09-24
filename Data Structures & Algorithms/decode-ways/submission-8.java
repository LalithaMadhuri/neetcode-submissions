/*

Letter to Number mapping

"12" => 12, 1 2 => 2 ways
"01" => 0 as there is a leading zero

"1012" => 10 12, 10 1 2

1. Overlapping subproblem

  1012
  a. 1 & 012
        0 & 12
        01 & 2
        012
  b. 10 & 12
     1 & 0, 1 & 2
  c. 101 & 2
     1 & 01, 2
     10 & 1, 2
  
  A-Z : 1-26

  1. String starts with 0 => return 0
  2. Substring starts with 0 => return 0
  3. Divide a string into multiple substrings and solve each substring to find num of ways

  a) string[i] & string[i+1: end]
  b) string[i: i+1] & string[i+2: end]

  Add a) and b)

  2. Definition of DP or what does state of dp store?

  dp(i) represents number of ways to decode string from index i to end of string

  3. Base Cases

  string starts with a leading zero => return 0
  string is empty/reached leaf node => return 1 as we found a way to decode input string
  index >= s.length() => return 0

*/

class Solution {
    public int numDecodings(String s) {
        return topDown(s, 0, new int[s.length() + 1]);
    }

    private int topDown(String s, int index, int[] memo){
        if(index == s.length()) return 1; // reached leaf node

        if(s.charAt(index) == '0') return 0;
        if(memo[index] != 0) return memo[index];
        
        // one digit 
        int oneDigit = topDown(s, index + 1, memo);
        int twoDigit = 0;

        // 2 digit
        if(index + 1 < s.length()){
            String substring = s.substring(index, index + 2);

            Integer number = Integer.parseInt(substring);

            if(number >= 10 && number <= 26)
                twoDigit = topDown(s, index + 2, memo);

        }
        
        memo[index] = oneDigit + twoDigit;

        return memo[index];



    }
}
