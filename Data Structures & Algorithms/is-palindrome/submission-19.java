/*

left = 0 and right = n - 1

loop through input string

if not character or digit skip
else compare characters at left and right if not equal => false
else true



*/
class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 1)
            return true;

        s = s.trim();

        int left = 0, right = s.length() - 1;

        while(left <= right){
            if(!Character.isLetterOrDigit(s.charAt(left)))
                {
                    left++;
                    continue;
                }


                if(!Character.isLetterOrDigit(s.charAt(right)))
                {
                    right--;
                    continue;
                
                }

                char leftChar = Character.toLowerCase(s.charAt(left));
                char rightChar = Character.toLowerCase(s.charAt(right));

                System.out.println(left);
                System.out.println(right);

                if(leftChar != rightChar){
                    return false;
                }
                left++;
                right--;

        }
        return true;
        
    }
}
