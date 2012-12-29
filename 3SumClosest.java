/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

import java.util.Arrays;

public class Solution {
    
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function                
        
        int n=0;
        int min=Integer.MAX_VALUE;
        
        Arrays.sort(num);
        
        for(int i=0; i<num.length-2; i++){
            int low = i+1;
            int high = num.length-1;
                       
            while(low < high){
                int sum = num[i] + num[low] + num[high];
                int diff = sum - target;
                
                if(diff==0)
                    return sum;
                if(Math.abs(diff)<min){
                    n = sum;
                    min = Math.abs(diff);
                }
                
                if(diff<0)
                    low++;
                else 
                    high--;                       
            }
        }
        
        return n;
    }
}
