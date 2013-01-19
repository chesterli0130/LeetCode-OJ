/*
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. 
You should gather all requirements up front before implementing one.
*/

public class Solution {
    
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        s = s.trim();
        
        boolean sign=false, e=false, dot=false;
        boolean number=false;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c=='+' || c=='-'){
                if(sign || number || dot){
                    return false;
                }
                
                sign=true;
            }else if(c=='.'){
                if(dot || e)
                    return false;
                    
                dot = true;
            }else if(c<='9' && c>='0'){
                number = true;
            }else if(c=='e'){
                if(!number || e)
                    return false;
                
                e = true;
                sign = false;
                number = false;
                dot = false;    //if don't set this, it will affect the sign after e
            }else{
                return false;
            }
        }
        
        return number;
    }
    
}
