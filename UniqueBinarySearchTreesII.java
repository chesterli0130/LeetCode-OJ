/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
 
public class Solution {
    
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        return buildTree(1, n);       
    }
    
    public ArrayList<TreeNode> buildTree(int start, int end){
        
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        
        if(start>end){
            result.add(null);
        }else{
            for(int i=start; i<=end; i++){           
                ArrayList<TreeNode> leftSet = buildTree(start, i-1);
                ArrayList<TreeNode> rightSet = buildTree(i+1, end);
                
                for(TreeNode left: leftSet){
                    for(TreeNode right: rightSet){
                        //for each pattern, it has to create new root
                        TreeNode root = new TreeNode(i);    
                        root.left = left;
                        root.right = right;
                        result.add(root);
                    }
                }        
            }
        
        }
                 
        return result;
    }
}
