/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/

// square will cause overflow, use long
public class Solution {
    public int sqrt(int x) {
         if (x<0){
             return-1;
         }
         
         // in case of x==1
        long high=x/2+1;
        long low=0;
        
        while(low<=high){
            long mid=low+(high-low)/2;
            
            long sq=mid*mid;
            
            if (sq==(long)x){
                return (int)mid;
            }
            else if (sq<(long)x){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return (int)high;
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
