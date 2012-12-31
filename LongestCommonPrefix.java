/*
Write a function to find the longest common prefix string amongst an array of strings.
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(strs.length==0)
            return "";
        
        String common = null;
        for(int i=0; i<strs.length; i++){
            common = commonPre(common, strs[i]);
        }
        
        return common;
    }
    
    public String commonPre(String str1, String str2){
        if(str1 == null)
            return str2;
        if(str2 == null)
            return str1;
    
        StringBuilder buff = new StringBuilder();
        
        int len = Math.min(str1.length(), str2.length());
        for(int i=0; i<len; i++){
            if(str1.charAt(i) == str2.charAt(i)){
                buff.append(str1.charAt(i));
            }else{
                break;
            }           
        }
        
        return buff.toString();
    }
}
