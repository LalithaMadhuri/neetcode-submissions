class Solution {
    public boolean isPalindrome(String s) {
        char[] charArr = s.toCharArray();
        StringBuilder reverseStr = new StringBuilder();

        for(char c: charArr){
            if(Character.isLetterOrDigit(c))
                reverseStr.append(Character.toLowerCase(c));
        }
       
        return reverseStr.toString().equals(reverseStr.reverse().toString());
        


        
    }
}
