/*
Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
*/

public class Solution {
    
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(haystack==null || needle==null)
            return null;
        
        if(needle.length()==0)
            return haystack;
        
        for(int i=0; i<haystack.length(); i++){
            boolean foundNotMatch = false;
            
            if(haystack.length()-i < needle.length())
                break;
            
            for(int j=0; j<needle.length(); j++){
                if(haystack.charAt(i+j) != needle.charAt(j))
                    foundNotMatch = true;
            }
            
            if(!foundNotMatch)  //all matching
                return haystack.substring(i);
        }
        
        return null;
    }
    
}
