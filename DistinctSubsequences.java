/*
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string 
by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. 
(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
*/

public class Solution {
    
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(S==null || T==null)
            return 0;
          
        if(T.length()==0)
            return 1;
        
        if(S.length()<T.length())
            return 0;
            
        if(S.charAt(0)==T.charAt(0)){
            return numDistinct(S.substring(1), T.substring(1)) + numDistinct(S.substring(1), T);
        }else{
            return numDistinct(S.substring(1), T);
        }
    }
    
}

public class Solution {
    
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int m = T.length();    //T as row
        int n = S.length();    //S as column
        
        int[][] dp = new int[m+1][n+1];
        
        //first row set 1
        for(int i=0; i<n+1; i++){
            dp[0][i] = 1;
        }
        
        //first columnn set 0
        for(int i=1; i<m+1; i++){
            dp[i][0] = 0;
        }
        
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(T.charAt(i-1)==S.charAt(j-1)){
                    //how many ways of representing the sequence before the character 
                    //+ how many ways to represent itself so far
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];  
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        
        return dp[m][n];
    }
    
}
