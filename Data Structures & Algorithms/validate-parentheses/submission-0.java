/*

() {} []

stack -> If char is not closing bracket push it to stack

if char is closing bracket => check stack.peek() if it's corresponding opening bracket => pop

keep continuing for all chars in string s

if stack is empty return true else false

TC: O(N)
SC: O(N) worst case



*/
class Solution {
    public boolean isValid(String s) {
        if(s.isEmpty())
            return false;

        Map<Character, Character> closingToOpen = Map.of('}','{',
                                                        ']', '[',
                                                        ')','(');

        Deque<Character> stack = new ArrayDeque<>();

        for(char ch: s.toCharArray()){
            if(!stack.isEmpty() && closingToOpen.containsKey(ch)){
                if(stack.peek() == closingToOpen.get(ch))
                    stack.pop();
                else
                    return false;
            }
            else
                stack.push(ch);
        }
        return stack.isEmpty() ? true: false;
        
    }
}
