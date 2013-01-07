/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, 
then the reverse of 1000000003 overflows. How should you handle such cases?

Throw an exception? Good, but what if throwing an exception is not an option? 
You would then have to re-design the function (ie, add an extra parameter).
*/

public class Solution {
    
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long rev=0;
        long num=x;
        boolean neg=false;
        
        if(num<0){
            neg = true;
            num = -num;
        }
        
        while(num!=0){
            rev = rev*10+num%10;
            num = num/10;
            
            if(neg && -rev<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            if(!neg && rev>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
        }
        
        return (int)(neg? -rev: rev);
    } 
}
