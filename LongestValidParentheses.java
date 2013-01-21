/*
Given a string containing just the characters '(' and ')', 
find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/

public class Solution {
    
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int open=0, close=0;
        int len=0;
        int max=0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                open++;
            }else{
                close++;
            }
            
            if(close==open){
                len += open*2;
                open = 0;
                close = 0;
                
                if(len>max)
                    max = len;
            }else if(close>open){
                len = 0;
                open = 0;
                close = 0;
            }
        }        
        
        len=0;
        open=0;
        close=0;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)==')'){
                open++;
            }else{
                close++;
            }
            
            if(close==open){
                len += open*2;
                open = 0;
                close = 0;
                
                if(len>max)
                    max = len;
            }else if(close>open){
                len = 0;
                open = 0;
                close = 0;
            }
        }
        
        return max;
    }
    
}

/*Better code*/
public class Solution {
    public int longestValidParentheses(String s) {
        if(s==null)    //error check
            return -1;
        
        int open = 0, close = 0;
        int maxLen = 0;
           
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(')
                open++;
            else if(s.charAt(i)==')'){
                close++;
            }
            
            //every time we find complete pairs, we just renew max length
            if(open==close && open+close > maxLen){
                maxLen = open+close;
            }
            
            if(close > open){   //if we find more close paren, it definitly is not valid, reset counts
                open = 0;
                close = 0;
            }            
        }
        
        open = 0; 
        close = 0;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)=='(')
                open++;
            else if(s.charAt(i)==')'){
                close++;
            }
            
            if(open==close && open+close > maxLen){
                maxLen = open+close;
            }
            
            if(close < open){   //if we find more open paren, it definitly is not valid, reset counts
                open = 0;
                close = 0;
            }            
        }
        
        return maxLen;
    }
}


