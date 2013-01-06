/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/

public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(n<=0)
            return -1; //throw exception!
        
        int low=0, high=x;
        long mid = (low+high)/2;
        
        while(high>=low){
            if(mid*mid > n){
                high = mid;
                if((mid-1)*(mid-1) < n)
                    return mid-1;
            }else if(mid*mid < n){
                low = mid;
                if((mid+1)*(mid+1) > n)
                    return mid;
            }else 
                return mid;
        }
        
        return mid;
    }
}

/*Method 2*/
public class Solution {

    public int sqrt(int x) {
        double upper=x, lower=0;
        double e = 0.00001;
        
        if(x==1)
            return 1;
        
        while(upper-lower > e){ //define the precision, so we stop when precision is achieved
            double pivot = (upper+lower)/2;
            
            if(pivot*pivot > x){    //larger               
                upper = pivot;
            }else if(pivot*pivot < x){    //smaller
                lower = pivot;
            }else{    //euqals
                return (int)pivot;
            }
        }    
              
        return (int)((upper+lower)/2);    
    }
}
