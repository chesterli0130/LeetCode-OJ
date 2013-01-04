/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return balance(root) != -1;
    }
    
    public int balance(TreeNode root){
        if(root==null)
            return 0;
        
        int left = balance(root.left);
        if(left==-1)
            return -1;
        
        int right = balance(root.right);
        if(right==-1)
            return -1;
        
        if(Math.abs(left-right)>1)
            return -1;
        
        return Math.max(left, right)+1;
    }
    
}
