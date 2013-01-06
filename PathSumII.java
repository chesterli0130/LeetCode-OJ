/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return result;
        int h = height(root);
        int[] a = new int[h];
        
        pathSum(root, sum, a, 0, result);
        return result;
    }
    
    public void pathSum(TreeNode root, int sum, int[] a, int index, ArrayList<ArrayList<Integer>> result){
        a[index] = root.val;
        
        if(root.left==null && root.right==null){
            if(root.val==sum){
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int i=0; i<=index; i++)
                    list.add(a[i]);
                result.add(list);
            }
        }
        
        if(root.left!=null)
            pathSum(root.left, sum-root.val, a, index+1, result);
        if(root.right!=null)
            pathSum(root.right, sum-root.val, a, index+1, result);
    }
    
    public int height(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(height(root.left), height(root.right))+1;        
    }
    
}
