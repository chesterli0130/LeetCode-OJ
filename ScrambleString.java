/*
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
*/


/*Recursive*/
public class Solution {
    /*If the order of comparison get changed, it may cause over time limitation*/
    /*It might because the test data*/
    
    public boolean isScramble(String s1, String s2) {
              
        if(isRotated(s1, s2))
            return true;
        
        int len = s1.length();
        
        for (int i=1; i <= len/2; i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(len-i);
            String s13 = s1.substring(i);            
            String s14 = s1.substring(0, len-i);            
            
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(len-i);
            String s23 = s2.substring(i);
            String s24 = s2.substring(0, len-i);

            if((isScramble(s11, s21) && isScramble(s13, s23)) || 
                (isScramble(s11, s22) && isScramble(s13, s24))||
                (isScramble(s12, s22) && isScramble(s14, s24))||
                (isScramble(s12, s21) && isScramble(s14, s23)))
            return true;          
        }
 
        return false;
    }
    
    public boolean isRotated(String s1, String s2){  
        return (s2+s2).contains(s1);
    }
    
}

/*DP */
/*Reference: http://blog.sina.com.cn/s/blog_b9285de20101gy6n.html*/
public class Solution {

    public boolean isScramble(String s1, String s2){
        int n=s1.length();
        /*dp[i][j][k], i is the start of s1, j is the start of s1, k is the string length, stores if such strings are scramble*/
        boolean[][][] dp=new boolean[n][n][n+1];
            
        for(int i=n-1; i>=0; i--)
            for(int j=n-1; j>=0; j--)
                for(int k=1; k<=n-Math.max(i,j);k++){
                    if(s1.substring(i,i+k).equals(s2.substring(j,j+k)))
                        dp[i][j][k]=true;                       
                    else{
                        for(int l=1; l<k; l++){
                            if(dp[i][j][l] && dp[i+l][j+l][k-l] || dp[i][j+k-l][l] && dp[i+l][j][k-l]){
                                dp[i][j][k]=true;
                                break;
                            }
                        }
                    }
                }
            
        return dp[0][0][n];
    }

}
