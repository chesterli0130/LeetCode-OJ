/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> in = new HashMap<Integer, Integer>();
        for(int i=0; i<inorder.length; i++){
            in.put(inorder[i], i);
        }
        
        return buildTree(preorder, in, 0, inorder.length-1, 0);
    }
    
    public TreeNode buildTree(int[] pre, HashMap<Integer, Integer> in, int start, int end, int preIndex){
        if(start>end)
            return null;
        
        int num = pre[preIndex];
        TreeNode root = new TreeNode(num);
        int index = in.get(num);
        int leftChildIndex = preIndex + 1;
        int rightChildIndex = preIndex + (index-start+1);
        
        root.left = buildTree(pre, in, start, index-1, leftChildIndex);
        root.right = buildTree(pre, in, index+1, end, rightChildIndex);
        
        return root;
    }
}
