/*

s1 = "abc"
s2 = "lecaabee"

map1 = {a: 1, b: 1, c: 1}
size = s1.length() = 3

left = 0, right = 2

map2 = {c: 1, a: 1, }
while right < s.length()

    map2.put(s.charAt(right), map2.getOrDefault(s.charAt(right), 0) + 1);

    if(right - left + 1 == size)
        if(map1.equals(map2))
            return true;
        else
            map2.put(s.charAt(left), map2.get(s.charAt(left)) - 1);
            if(map2.get(s.charAt(left)) == 0) map2.remove(s.charAt(left));
            left++;

    
    right++;

return false;







*/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int left = 0, right = 0;
        Map<Character, Integer> countS1 = new HashMap<>();
        Map<Character, Integer> countS2 = new HashMap<>();

        for(char ch: s1.toCharArray())
            countS1.put(ch, countS1.getOrDefault(ch, 0) + 1);

        while(right < s2.length()){
            countS2.put(s2.charAt(right), countS2.getOrDefault(s2.charAt(right), 0) + 1);

            if((right - left + 1) == s1.length()){
                if(countS1.equals(countS2))
                    return true;
                else
                    countS2.put(s2.charAt(left), countS2.get(s2.charAt(left)) - 1);
                    if(countS2.get(s2.charAt(left)) == 0)
                        countS2.remove(s2.charAt(left));
                    left++;
            }

            right++;
        }
        return false;
        
    }
}
