/*
Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

public class Solution {
    
    public int searchInsert(int[] a, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(a.length==0)
            return 0;
        
        return search(a, target, 0, a.length-1);
    }
    
    public int search(int[] a, int target, int left, int right){
        if(left>right)
            return -1;    
        
        int mid = left+(right-left)/2;
        if(a[mid]==target)
            return mid;
        else if(a[mid] > target){
            int ret = search(a, target, left, mid-1);
            if(ret==-1)
                return mid;
            else
                return ret;
        }else{ 
            int ret = search(a, target, mid+1, right);
            if(ret==-1)
                    return mid+1;
            else
                return ret;
        }    
    }
}
