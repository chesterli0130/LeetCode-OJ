/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

public class Solution {
    
    public int maxSubArray(int[] a) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max=Integer.MIN_VALUE;
        int sum=0;
        
        for(int i=0; i<a.length; i++){
            sum += a[i];
            
            if(sum>max)
                max = sum;
            
            if(sum<0)
                sum = 0;
        }
        
        return max;
    } 
}
