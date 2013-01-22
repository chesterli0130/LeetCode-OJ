/*
Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/

/*Brute Force: O(N^3)*/
public class Solution {
    
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(s==null) 
            return null;
        
        for(int len=s.length(); len>0; len--){
            for(int start=0; start+len<=s.length(); start++){
                int end = start+len-1;
                
                if(isPalidrome(s, start, end))
                    return s.substring(start, end+1);
            }
        }
        
        return "";
        
    }
    
    public boolean isPalidrome(String s, int start, int end){
        
        while(start<end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        
        return true;
    }   
}


