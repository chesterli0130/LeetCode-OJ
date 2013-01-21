/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
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
    
    class Wrapper{
        int val=Integer.MIN_VALUE;
    }
    
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        Wrapper max = new Wrapper();
        maxPath(root, max);
        
        return max.val;
    }
    
    
    public int maxPath(TreeNode root, Wrapper max){
        if(root==null)
            return 0;
            
        int localMax = root.val;
        int left = maxPath(root.left, max);
        if(left>0) 
            localMax += left;
        
        int right = maxPath(root.right, max);
        if(right>0) 
            localMax += right;
                    
        max.val = Math.max(max.val, localMax);
        
        return max(root.val, left+root.val, right+root.val);
    }
    
    public int max(int a, int b, int c){
        return Math.max(Math.max(a, b), c);
    }
}
