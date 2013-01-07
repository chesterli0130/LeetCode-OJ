/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/

public class Solution {
    
    public boolean search(int[] a, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return search(a, target, 0, a.length-1);
    }
    
    public boolean search(int[] a, int target, int left, int right){
        if(left>right)
            return false;
            
        int mid = left+(right-left)/2;
        if(a[mid]==target)
            return true;
        
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
        }else{ 
            if(target<=a[right] && target>a[mid])
                return search(a, target, mid+1, right);
            else{ //check both side
                boolean ret = search(a, target, left, mid-1);
                if(ret)
                    return ret;
                    
                return search(a, target, mid+1, right);
            }
        }
    }
}
