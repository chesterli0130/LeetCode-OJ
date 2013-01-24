/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
(each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/

/*Recursive*/
public class Solution {
    
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(word1==null || word2==null)
            return 0;
        
        if(word1.length()==0)
            return word2.length();        
        
        if(word2.length()==0)
            return word1.length();
            
        if(word1.charAt(0)==word2.charAt(0)){
            return minDistance(word1.substring(1), word2.substring(1));
        }else{
            return 1 + min(minDistance(word1, word2.substring(1)), 
                            minDistance(word1.substring(1), word2.substring(1)),
                            minDistance(word1.substring(1), word2));
        }
    }
    
    public int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
    
}

/*DP*/
public class Solution {
    
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = word2.length();
        int n = word1.length();
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0; i<m+1; i++)
            dp[i][0] = i;
        
        for(int j=0; j<n+1; j++)
            dp[0][j] = j;
        
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(word2.charAt(i-1)!=word1.charAt(j-1)){
                    dp[i][j] = 1 + min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]);
                }else{
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        
        return dp[m][n];
    }
    
    public int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}

