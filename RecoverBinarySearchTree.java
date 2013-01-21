/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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
        TreeNode first, second;
        TreeNode last;
    }

    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        Wrapper w = new Wrapper();
        recover(root, w);
        
        if(w.first!=null && w.second!=null){
            int temp = w.first.val;
            w.first.val = w.second.val;
            w.second.val = temp;
        }
    }
    //use recursion, so the space would be O(logN), where N is the number of node.
    //It's better than O(N), although still not O(1)
    public void recover(TreeNode root, Wrapper w){
        if(root==null)
            return;
        
        recover(root.left, w);
        
        if(w.last!=null){
            if(w.last.val > root.val){
                if(w.first==null){
                    w.first = w.last;
                }
                
                w.second = root;
            }
        }
        w.last = root;
        
        recover(root.right, w);
    }
    
}
