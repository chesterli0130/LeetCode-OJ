/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/

public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(n<=0)
            return "";
        if(n==1)
            return "1";
        
        String str = say(n-1);
        char last = str.charAt(0);
        int count = 1;
        StringBuilder buff = new StringBuilder();
        
        for(int i=1; i<str.length; i++){
            char c = str.charAt(i);
            if(c==last){
                count++;
            }else{
                buff.append(count);
                buff.append(c);
                last = c;
                count = 1;
            }
        }
        buff.append(count);
        buff.append(c);
        
        return buff.toString();
    }
}
