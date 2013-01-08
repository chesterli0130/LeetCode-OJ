/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/

public class Solution {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        
        return ways(obstacleGrid, m-1, n-1, dp);        
    }
    
    public int ways(int[][] matrix, int i, int j, int[][] dp){
        if(matrix[i][j]==1)
            return 0;
        
        if(dp[i][j]>-1)
            return dp[i][j];
        
        if(i==0 && j==0)
            return 1;
        else if(i==0)
            dp[i][j] = ways(matrix, i, j-1, dp);
        else if(j==0)
            dp[i][j] = ways(matrix, i-1, j, dp);
        else
            dp[i][j] = ways(matrix, i-1, j, dp) + ways(matrix, i, j-1, dp);
    
        return dp[i][j];
    }
}
