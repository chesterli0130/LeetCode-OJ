/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
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
    
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(root==null)
            return;
        
        if(root.left!=null){
            rightMost(root.left).right = root.right; 
            root.right = root.left;
        }        
        
        root.left = null;
        flatten(root.right);
    }
    
    public TreeNode rightMost(TreeNode root){
        if(root.right==null)
            return root;
        else
            return rightMost(root.right);
    }
    
}
