/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
*/

public class Solution {
    public int removeDuplicates(int[] a) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(a.length==0)
            return 0;
        
        int last=a[0];
        int count=1;
        int endIndex=0;
        
        for(int i=1; i<a.length; i++){
            if(a[i]!=last){
                endIndex++;
                a[endIndex] = a[i];
                last = a[i];
                count = 1;
            }else if(count<2){
                endIndex++;
                a[endIndex] = a[i];
                count++;
            }
        }
        
        return endIndex+1;
    }
}
