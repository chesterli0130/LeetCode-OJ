/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/


/*Time: O(N)*/
public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s==null)
            return true;
        
        s = s.toLowerCase();
        int i=0, j=s.length()-1;
        
        while(i<=j){
            char a = s.charAt(i);
            char b = s.charAt(j);
            
            if(!isAlphanumeric(a)){ //also Character.isLetterOrDigit(char c)
                i++;
            }else if(!isAlphanumeric(b)){
                j--;
            }else if(a!=b){
                return false;
            }else{
                i++;
                j--;
            }
        }
        
        return true;
    }
    
    public boolean isAlphanumeric(char c){
        return (c>='a' && c<='z') || (c>='0' && c<='9'); 
    }
}

