/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int[] dp = new int[n+1];
        return count(n, dp);
    }
    
    public int count(int n, int[] dp){
        if(n<0)
            return 0;
        if(n==0)
            return 1;
        
        if(dp[n]>0)
            return dp[n];
        
        dp[n] = count(n-1, dp) + count(n-2, dp);
        return dp[n];
    }
}
