/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
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
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)
            return true;
        return symmetric(root.left, root.right);
    }
    
    public boolean symmetric(TreeNode left, TreeNode right){
        if(left==null && right==null)
            return true;
        else if(left==null || right==null)
            return false;
        
        if(left.val != right.val)
            return false;
        
        return symmetric(left.left, right.right) && symmetric(left.right, right.left);
    }
}
