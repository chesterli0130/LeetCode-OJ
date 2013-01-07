/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

/*Recursive*/
public class Solution {
    
    public int numDecodings(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(str==null || str.length()==0)
            return 0;
                
        return ways(str);
    }
    
    public int ways(String str) {
        
        if(str.length()==0)
            return 1;
            
        int ways=0;
        
        char fc=str.charAt(0);
        if(fc=='0')
            return 0;
        
        ways += ways(str.substring(1));
        
        if(str.length()>1){
            int num = (fc-'0')*10 + (str.charAt(1)-'0');
            if(num<=26)
                ways += ways(str.substring(2));
        }
        return ways;       
    }
    
}

/*DP: O(N)*/
public class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0)=='0')    //if the string start with 0, it is definitely wrong code
            return 0;
        
        return count(s);
    }
    
    public int count(String s){
        int len = s.length();
        int[] ways = new int[len];
        int[] str = new int[len];
        
        //Convert the string into int array
        //Check if the input is valid. If there are undecodable codes, then return
        for(int i=0; i<len; i++){       
            str[i] = s.charAt(i)-'0';
            
            if(i>0 && str[i] == 0 && (str[i-1] != 1 && str[i-1] != 2))  //for 0, it just can show in 10 or 20. For other case all wrong, like 00, 30, 40...
                return 0;
        }
        
        //set the first element
        ways[0] = 1;             
        if(len != 1){   //if the length of string is 1, there are just one way
            
            //set second element
            int num = str[0] * 10 + str[1]; //check if there are two ways can encoding it           
            if(num <= 26 && num%10 != 0){       //base case, if there are 2 ways
                ways[1] = 2;
            } else{
                ways[1] = 1;
            }
            
            //create other elements
            for(int i=2; i<len; i++){
                num = str[i-1]*10 + str[i];
                
                //str[i] == 0, str[i] has to be decode with str[i-1], so str[i-1] would not be with str[i-2], 
                //then ways[i] = ways[i-2]
                if(str[i]%10 == 0){     
                    ways[i] = ways[i-2];
                }else if(num <=26 && num > 10){     //this means str[i-1] can be decoded with str[i] or str[i-2]
                    ways[i] =  ways[i-1] +  ways[i-2];
                }else{      //for other case, num > 26, so str[i] has to be encode by itself, ways[i] is not changed
                    ways[i] = ways[i-1];
                }
            }
        }
               
        return ways[len-1];
    }
}
