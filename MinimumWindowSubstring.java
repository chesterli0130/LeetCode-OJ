/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/

/*Thoughts: typical two pointers problem*/

public class Solution {
    
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int[] tHash = new int[256]; //hash(char, numbers)
        int[] count = new int[256]; //keep the number for each char's number in window
        
        for (int i = 0; i < T.length(); i++) {
            tHash[(int)T.charAt(i)]++; 
        }
        
        int min = Integer.MAX_VALUE; //could be S.length()+1
        String result = "";
        int matched=0;
        
        int start=0, end=0;
                    
        while(end<=S.length()){
            
            if(matched==T.length()){   //find a window
                int len = end-start;
                if(len < min){
                    min = len;
                    result = S.substring(start, end);
                }
                
                //move head to next char in T
                int c = (int)S.charAt(start);
                count[c]--;
                
                //if start element makes count's number smaller than the number in T's hash
                //then it affects the matching
                if(count[c]<tHash[c] && tHash[c]>0) 
                    matched--;
                
                start++;
                while(start<end && tHash[(int)S.charAt(start)]==0){
                    start++;
                }
                
            }else if(end<S.length()){
                int c = (int)S.charAt(end);
                count[c]++;
                
                //if the current character is in T and it still needs more char to make matching 
                if(tHash[c]>0 && count[c]<=tHash[c]){
                    matched++;                    
                }                
                end++;
            }else{  //when end==S.length(), no more char for end and no more matching possiblity
                end++;
            }        
        }
        
        return result;
    }
    
}

