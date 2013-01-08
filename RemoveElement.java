/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/

public class Solution {
    public int removeElement(int[] a, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int endIndex=-1;
        
        for(int i=0; i<a.length; i++){
            if(a[i]!=elem){
                endIndex++;
                a[endIndex] = a[i];
            }
        }
        
        return endIndex+1;
    }
}
