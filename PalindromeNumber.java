/*
Determine whether an integer is a palindrome. Do this without extra space.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. 
However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. 
How would you handle such case?

There is a more generic way of solving this problem.
*/

public class Solution {
    
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x<0){
            return false;
        }else if(x==0){
            return true;
        }
        
        int divisor=1;
        int temp = x;
        
        //get divisor to get the first digit
        while(temp/10!=0){
            divisor*=10;
            temp/=10;
        }
        
        return isPalindrome(x, divisor);
    }
    
    public boolean isPalindrome(int x, int divisor){
        if(divisor==1 || divisor==0)
            return true;
        
        int left = x/divisor;
        int right = x%10;
        
        if(left!=right)
            return false;
        
        return isPalindrome((x%divisor)/10, divisor/100);
    }
}
