/*
Divide two integers without using multiplication, division and mod operator.
*/

public class Solution {
    public int divide(int dividend, int divisor) {
        
        
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        boolean neg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        
        if (divisor == 0) {    //error check, should throw exception
            return Integer.MAX_VALUE;
        }
        
        if (divisor == Integer.MIN_VALUE) {     //if divisor is the smallest number, no one is dividable by it except itself
            return (dividend == Integer.MIN_VALUE) ? 1 : 0;
        }
        
        if (dividend == Integer.MIN_VALUE) {    //if diviend is the smallest number, we cannot convert it into positive, so you need to add a the absolute value of divisor
            if (neg) {
                return -1 + divide(dividend + b, divisor);  //if negative, the result would be negative, so + (-1)
            }
            else {
                return 1 + divide(dividend + b, divisor);   //if postive, then add 1
            }
        }
        
        int product = b;
        int result = 0;
        while (a >= b) {    
            
            int q = 1;  //quotient. If a is larger than b, the quotient is at least equals to 1
            while (a-product >= product) {  //it means a >= product*2 (or <<1). if the next round the product would be larger than a, then stop. Use minus can avoid overflow
                q = q << 1;     // it equals to *2, we try the quotient times 2 for each round. like 1, 2, 4, 8, 16
                product = product << 1; //product also *2
            }
            
            a = a - product;    //if a is still larger than b, then from 1 try again
            product = b;
            result += q;
                       
        }
        return (neg) ? -result : result;
    }
}
