/*
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") -> false
isMatch("aa","aa") -> true
isMatch("aaa","aa") -> false
isMatch("aa", "*") -> true
isMatch("aa", "a*") -> true
isMatch("ab", "?*") -> true
isMatch("aab", "c*a*b") -> false
*/

/*DP: Overtime*/
public class Solution {
    
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(s==null || p==null)
            return false;
        
        int m = s.length();
        int n = p.length();
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                dp[i][j] = -1;
            }
        }
        
        return isMatch(s, p, dp)>0? true: false;
    }
    
    public int isMatch(String s, String p, int[][] dp){
        if(dp[s.length()][p.length()]>-1)
            return dp[s.length()][p.length()];
        
        if(s.length()==0 && p.length()==0)
            return 1;
        
        if(p.length()==0)
            return 0;
       
        char pFirst = p.charAt(0);
        if(s.length()==0){
            return onlyStar(p);
        } 
        
        if(pFirst=='*'){
            dp[s.length()][p.length()] = isMatch(s.substring(1), p, dp)+isMatch(s, p.substring(1), dp);
        }else if(pFirst=='?' || s.charAt(0)==pFirst){
            dp[s.length()][p.length()] = isMatch(s.substring(1), p.substring(1), dp);        
        }else{
            dp[s.length()][p.length()] = 0;
        }
              
        return dp[s.length()][p.length()];
    }
    
    public int onlyStar(String s){
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!='*')
                return 0;
        }
        return 1;
    }
    
}


/*Iterative method*/
/*Reference: http://blog.sina.com.cn/s/blog_b9285de20101gw2x.html*/
public class Solution {
    
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
    
        int m = s.length();
        int n = p.length();
        
        int i=0, j=0;
        int starIndex=-1, sIndex=0;
        
        while(i<m){
            
            //skip all * first
            while(j<n && p.charAt(j)=='*'){
                starIndex = j++;  //keep the position of *
                sIndex = i; //the position of s when come across * 
            }
            
            if(j==n || ('?'!=p.charAt(j) && s.charAt(i)!=p.charAt(j))){
                if(starIndex==-1){
                    return false;   //no star to match
                }else{  //go back, check again from the next of *
                    j = starIndex+1;
                    i = sIndex+1;   //back to the position meet *. plus 1 means using * to match the char
                    sIndex++;   //renew sIndex
                }                
            }else{  //chars matches
                i++;
                j++;
            }
        }
        
        while(j<n){ //if there are still chars in p, then they are only *
            if(p.charAt(j++)!='*'){
                return false;
            }
        }
        
        return true;
    }
        
}


