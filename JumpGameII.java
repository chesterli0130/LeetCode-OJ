/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/

public class Solution {
    
    public int jump(int[] a) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int endIndex=a.length-1;
        int steps=0;
        
        while(endIndex!=0){
            int start = -1;
            
            //from the first element to check the first one can reach the last by one jump
            //then reduce the problem
            for(int i=0; i<endIndex; i++){
                if(endIndex-i<=a[i]){
                    start = i;
                    break;
                }
            }
            
            if(start==-1)   //unreachable
                return -1;
            
            endIndex = start;
            steps++;
        }
        
        return steps;
    }    
}

