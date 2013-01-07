/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

public class Solution {
    
    public int[] searchRange(int[] a, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        
        searchRange(a, target, 0, a.length-1, result);
        return result;
    }
    
    public void searchRange(int[] a, int target, int left, int right, int[] result){
        if(left>right)
            return;
        
        int mid = left+(right-left)/2;
        
        if(a[mid] > target){
            searchRange(a, target, left, mid-1, result);
        }else if(a[mid] < target){
            searchRange(a, target, mid+1, right, result);
        }else{
            if(result[0]==-1 || result[0]>mid)
                result[0] = mid;
            if(result[1]==-1 || result[1]<mid)
                result[1] = mid;
            searchRange(a, target, left, mid-1, result);
            searchRange(a, target, mid+1, right, result);
        }
    }
    
}
