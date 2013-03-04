/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/

/* 
a dp for check palindrome
a dp for dfs
*/

public class Solution {

    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int len = s.length();
        boolean[][] isPalin = new boolean[len][len];
        
        for(int i=0; i<len; i++){
            isPalin[i][i] = true;
            if(i<len-1)
                isPalin[i+1][i] = true;
        }
            
        for(int i=1; i<len; i++){
            for(int j=0; i+j<len; j++){
                int x = j;
                int y = j+i;
                if(s.charAt(x)==s.charAt(y) && isPalin[x+1][y-1])
                    isPalin[x][y] = true;
            }
        }
        
        int[][] dp = new int[len][len];
        
        return partition(s, 0, s.length()-1, isPalin, dp);
    }
    
    public int partition(String s, int start, int end, boolean[][] isPalin, int[][] dp){
        if(isPalin[start][end])
            return 0;
        
        if(dp[start][end]>0)
            return dp[start][end];
        
        int min=Integer.MAX_VALUE;
        for(int i=end-1; i>=start; i--){
            if(isPalin[start][i]){
                int ret = partition(s, i+1, end,isPalin, dp);               
                min = Math.min(ret, min);           
            }
        }       
        
        dp[start][end] = min + 1;
        return dp[start][end];
    }

}
