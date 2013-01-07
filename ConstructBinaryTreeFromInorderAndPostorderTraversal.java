/*
Given inorder and postorder traversal of a tree, construct the binary tree.

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
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return buildTree(postorder, map, 0, inorder.length-1, postorder.length-1);
    }
    
    public TreeNode buildTree(int[] post, HashMap<Integer, Integer> map, int start, int end, int rootIndex){
        if(start>end)
            return null;
        
        int num = post[rootIndex];
        TreeNode root = new TreeNode(num);
        int index = map.get(num);
        
        int rightChildIndex = rootIndex-1;
        int leftChildIndex = rootIndex-(end-index+1);
        
        root.left = buildTree(post, map, start, index-1, leftChildIndex);
        root.right = buildTree(post, map, index+1, end, rightChildIndex);
        
        return root;
    }
    
}

