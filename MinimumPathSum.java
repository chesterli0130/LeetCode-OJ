/*
Given a m x n grid filled with non-negative numbers, 
find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

public class Solution {
    
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        
        return minPathSum(grid, dp, m-1, n-1);   
    }
    
    public int minPathSum(int[][] grid, int[][] dp, int i, int j){
        
        if(dp[i][j]>-1)
            return dp[i][j];
        
        if(i==0 && j==0){
            return grid[i][j];
        }else if(i==0){
            dp[i][j] = minPathSum(grid, dp, i, j-1) + grid[i][j];
        }else if(j==0){
            dp[i][j] = minPathSum(grid, dp, i-1, j) + grid[i][j];
        }else{
            dp[i][j] = Math.min(minPathSum(grid, dp, i-1, j), minPathSum(grid, dp, i, j-1)) + grid[i][j];
        }
        
        return dp[i][j];
    }
    
}
