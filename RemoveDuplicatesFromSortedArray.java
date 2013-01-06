/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
*/

public class Solution {
    public int removeDuplicates(int[] a) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(a.length==0)
            return 0;
        
        int last=a[0];
        int endIndex=0;
        
        for(int i=0; i<a.length; i++){
            if(a[i]!=last){
                endIndex++;
                a[endIndex] = a[i];
                last = a[i];
            }
        }
        
        return endIndex+1;
    }
}
