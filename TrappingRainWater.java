/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped.
*/

public class Solution {
    public int trap(int[] a) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sum1=0, sum2=0;
        
        int max=a[0];
        int maxIndex=0;
        int temp=0;
        
        //get sum of left part of the max bucket
        for(int i=1; i<a.length; i++){
            if(a[i]>=max){
                max = a[i];
                maxIndex = i;
                sum1 = temp;
            }else{
                temp += max - a[i];
            }
        }
        
        int endIndex = maxIndex; //maxIndex now would be the max bucket's index
        maxIndex = a.length-1;
        max=a[maxIndex];
        temp=0;
        
        //get sum of right part of the max bucket       
        for(int i=a.length-2; i>=endIndex; i--){
            if(a[i]>=max){
                max = a[i];
                maxIndex = i;
                sum2 = temp;
            }else{
                temp += max-a[i];
            }
        }
        
        return sum1+sum2;
    }
}
