/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/

/*Recursive: O(3^N)*/
public class Solution {
    
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(s.length()==0 && p.length()==0)
            return true;
        
        if(p.length()==0)
            return false;
            
        char pLast = p.charAt(p.length()-1);
        
        if(pLast=='*'){
            if(p.length()!=1){  //"*" cannot be the first char
                char pre = p.charAt(p.length()-2);
                
                if(s.length()!=0 && (pre==s.charAt(s.length()-1)|| pre=='.')){
                    return isMatch(s.substring(0, s.length()-1), p.substring(0, p.length()-2))
                        || isMatch(s.substring(0, s.length()-1), p)
                        || isMatch(s, p.substring(0, p.length()-2));
                }else{
                    return isMatch(s, p.substring(0, p.length()-2));
                }
            }
        }else if(s.length()!=0 && (pLast==s.charAt(s.length()-1) || pLast=='.')){
            return isMatch(s.substring(0, s.length()-1), p.substring(0, p.length()-1));
        }
        
        return false;                
    }
    
}

