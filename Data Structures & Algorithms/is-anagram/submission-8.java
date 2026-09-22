class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
            return false;

        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();

        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();

        for(int i=0; i < s.length(); i++){
            sCount.put(sSort[i], sCount.getOrDefault(sSort[i], 0) + 1);
            tCount.put(tSort[i], tCount.getOrDefault(tSort[i], 0) + 1);

        }
        
        if(sCount.equals(tCount))
            return true;
        return false;
    }
}
