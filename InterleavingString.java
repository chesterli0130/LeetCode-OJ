/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/

/*Recursive*/
public class Solution {
    
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(s1.length()==0)
            return s2.equals(s3);

        if(s2.length()==0)
            return s1.equals(s3);
    

        if(s1.charAt(0) == s3.charAt(0)){
            if(isInterleave(s1.substring(1), s2, s3.substring(1)))
                return true;    
        }       

            
        if(s2.charAt(0) == s3.charAt(0)){
            if(isInterleave(s1, s2.substring(1), s3.substring(1)))
                return true;       
        }
                
        return false;
    }
    
}

/*DP*/
public class Solution {
    
    public boolean isInterleave(String s1, String s2, String s3){
        
        if(s1==null || s2==null || s3==null)
            return false;
            
        int l1=s1.length();
        int l2=s2.length();
        int l3=s3.length();
        if(l1+l2!=l3)
            return false;
            
        boolean[][] dp=new boolean[l1+1][l2+1];
        dp[l1][l2]=true;
        
        for(int i=l1;i>=0;i--){
            for(int j=l2;j>=0;j--){
                
                if(i<l1 && s1.charAt(i)==s3.charAt(i+j) && dp[i+1][j])
                    dp[i][j]=true;
                
                if(j<l2 && s2.charAt(j)==s3.charAt(i+j) && dp[i][j+1])
                    dp[i][j]=true;
            }
        }
        
        return dp[0][0];
    }
    
}
