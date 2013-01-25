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


/*DP: O(n^2)*/
public class Solution {
    
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int m = s.length();
        int n = p.length();
        
        //-1: unvisited; 0: not matching; 1: matching
        int[][] feasible = new int[m+1][n+1];
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                feasible[i][j] = -1;
            }
        }
        
        return isMatch(s, p, feasible)>0? true : false;
    }
    
    public int isMatch(String s, String p, int[][] feasible) {

        if(s.length()==0 && p.length()==0)
            return 1;
        
        if(p.length()==0)
            return 0;
        
        if(feasible[s.length()][p.length()]>-1){
            return feasible[s.length()][p.length()];
        }
        
        char pLast = p.charAt(p.length()-1);
        
        if(pLast=='*'){
            if(p.length()!=1){  //"*" cannot be the first char
                char pre = p.charAt(p.length()-2);
                
                if(s.length()!=0 && (pre==s.charAt(s.length()-1)|| pre=='.')){
                    feasible[s.length()][p.length()] = 
                        isMatch(s.substring(0, s.length()-1), p.substring(0, p.length()-2), feasible)
                        + isMatch(s.substring(0, s.length()-1), p, feasible)
                        + isMatch(s, p.substring(0, p.length()-2), feasible);
                        
                }else{
                    feasible[s.length()][p.length()] = isMatch(s, p.substring(0, p.length()-2), feasible);
                }
            }
        }else if(s.length()!=0 && (pLast==s.charAt(s.length()-1) || pLast=='.')){
            feasible[s.length()][p.length()]=isMatch(s.substring(0, s.length()-1), p.substring(0, p.length()-1), feasible);
        }else{
            feasible[s.length()][p.length()]=0;
        }
        
        return feasible[s.length()][p.length()];                
    }
    
}


