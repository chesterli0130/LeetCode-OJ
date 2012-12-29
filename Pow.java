/*
Implement pow(x, n).
*/

public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function        
        
        if(n<0)
            return 1/(x*pow(x, -(n+1)));    //preventing from overflow, when n is Integer.MIN_VALUE
        
        if(n==0){
            return 1;
        }else if(n%2==1){
            return x*pow(x, n-1);
        }else{
            double num = pow(x, n/2);   
            return num*num;
        }
    }
}
