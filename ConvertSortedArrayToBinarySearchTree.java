/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        return build(num, 0, num.length-1);
    }
    
    public TreeNode build(int[] a, int left, int right){
        if(left>right)
            return null;
        
        int mid = left+(right-left)/2;
        TreeNode root = new TreeNode(a[mid]);
        
        root.left = build(a, left, mid-1);
        root.right = build(a, mid+1, right);
        
        return root;
    }
}
