/*
A robot is located at the top-left corner of a m x n grid.

The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid.

How many possible unique paths are there?
*/

public class Solution {
    
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] dp = new int[m][n];
        return ways(m-1, n-1, dp);
    }
    
    public int ways(int i, int j, int[][] dp){
        if(i==0 || j==0)
            return 1;
        
        if(dp[i][j]>0)
            return dp[i][j];
        
        dp[i][j] = ways(i-1, j, dp)+ways(i, j-1, dp);
        return dp[i][j];
    }
}

