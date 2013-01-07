/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

public class Solution {
    
    public int search(int[] a, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return search(a, target, 0, a.length-1);
    }
    
    public int search(int[] a, int target, int left, int right){
        if(left>right)
            return -1;
            
        int mid = left+(right-left)/2;
        if(a[mid]==target)
            return mid;
        
        if(a[mid] < a[left]){
            if(target<=a[right] && target>a[mid])
                return search(a, target, mid+1, right);
            else
                return search(a, target, left, mid-1);
        }else if(a[mid] > a[left]){
            if(target>=a[left] && target<a[mid])
                return search(a, target, left, mid-1);
            else
                return search(a, target, mid+1, right);
        }else{ //mid and left are same, because no duplicate
            return search(a, target, mid+1, right);
        }
    }
}
