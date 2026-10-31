class Solution {
    String s;
    Set<String> words;
    public int minExtraChar(String s, String[] dictionary) {
        this.s = s;
        this.words = new HashSet<>();

        for(String word: dictionary)
            words.add(word);

        return topDown(0, 0, new Integer[s.length()][s.length()]);
        
    }
    private int topDown(int start, int end, Integer[][] memo){
        if(end >= s.length()){
            if(words.contains(s.substring(start, end)))
                return 0;
            return end - start;
        }
        if(memo[start][end] != null) return memo[start][end];

        if(words.contains(s.substring(start, end + 1))){
            memo[start][end] = Math.min(topDown(end + 1, end + 1, memo), topDown(start, end + 1, memo));
            return memo[start][end];
        }
             
        memo[start][end] = Math.min(topDown(start, end + 1, memo), (end - start + 1) + topDown(end + 1, end + 1, memo));
        return memo[start][end];
    }
}