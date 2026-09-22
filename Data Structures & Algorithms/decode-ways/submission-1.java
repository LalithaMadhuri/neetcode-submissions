class Solution {
    public int numDecodings(String s) {
        return topDown(s,0, new int[s.length()]);
        
    }
    private int topDown(String s, int i, int[] memo){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0')  return 0;
        if(memo[i] != 0) return memo[i];

        int res = topDown(s, i+1, memo); // one digit and solve for rest

        if(i < s.length() - 1){ // solve for 2 digits and rest of string
            if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) < '7')) // 2 digits shud be <= 26
                res += topDown(s,i+2, memo);
        }
        memo[i] = res;
        return memo[i];
    }
}
