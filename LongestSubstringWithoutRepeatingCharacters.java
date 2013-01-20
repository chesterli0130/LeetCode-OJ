/*
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
For "bbbbb" the longest substring is "b", with the length of 1.
*/


//O(N^2)
public class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        if(s==null)
            return -1;
        if(s.length()==0 || s.length()==1)
            return s.length();
        
        //to here, s has at least two elements
        int maxLen = 1;
        int start = 0, end = 1; //end points the element we are checking
        
        while(end<s.length()){
            int ret = hasChar(s, start, end, s.charAt(end));    //check if the string [start, end) contains s.charAt(end)
                
            if(ret != end){ // if contains, we can just cut those element before the same one
                int len = end - start;
                if(len>maxLen){
                    maxLen = len;
                }
                start = ret+1;  //set the new start to the next of the same one
            }
            
            end++;                
        }
        
        int len = end - start;
        if(len>maxLen){
            maxLen = len;
        }
        
        return maxLen; 
    }
    
    public int hasChar(String s, int start, int end, char c){
        for(int i=start; i<end; i++){
            if(s.charAt(i)==c)  //if contains, return the index of same one
                return i;         
        }        
        return end; //if not contains, return the index of end
    }
}

//use hash table to reduce the time of checking duplicate
public class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int max=0;
        int start=0;
        int[] hash = new int[26];
        
        for(int i=0; i<hash.length; i++){
            hash[i]=-1;
        }        
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int index = hash[c-'a'];
            
            //when we found duplicate
            if(index>-1){
                int len = i-start;               
                max = Math.max(len, max);               
                
                //we renew the hash
                for(int j=start; j<=index; j++){
                    hash[s.charAt(j)-'a'] = -1;
                }
                //we set the new start as the next of the old duplicate numnber's index
                start = index+1;
            }
                
            hash[c-'a'] = i;            
        }
        
        max = Math.max(s.length()-start, max);
        
        return max;
    }
    
}
