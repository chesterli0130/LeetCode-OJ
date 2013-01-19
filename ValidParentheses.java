/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            switch(c){
                case '(':
                case '[':
                case '{': stack.push(c);
                          break;
                case ')': if(stack.isEmpty() || stack.pop()!='(')
                            return false;
                          break;
                case ']': if(stack.isEmpty() || stack.pop()!='[')
                            return false;
                          break;
                case '}': if(stack.isEmpty() || stack.pop()!='{')
                            return false;
                          break;
                default: return false;
            }
        }
        
        return stack.isEmpty();
    }
    
}
