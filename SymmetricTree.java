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


/*Iterative Method*/
/*By level order traversal, check if the next level is palindrome*/
import java.util.LinkedList; 
import java.util.ArrayList;
 
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<TreeNode> level = new ArrayList<TreeNode>();    //store the elements in one level, including null
        int current = 1, next = 0;
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode n = queue.remove();
            
            if(n.left!=null){
                next++;
                queue.add(n.left);
            }
            level.add(n.left);	//even if n.left is null, it still store in the array
            
            if(n.right!=null){
                next++;
                queue.add(n.right);
            }
            level.add(n.right);	//even if n.right is null, it still store in the array
            
            current--;
            if(current==0){
                if(!isPalindrome(level))	//check if the next level is palindrome
                    return false;
                current = next;
                next = 0;
                level.clear();
            }
        }
        
        return true;
    }
    
    public boolean isPalindrome(ArrayList<TreeNode> level){
        int i=0, j=level.size()-1;
        
        while(i<j){
            if(level.get(i)==null && level.get(j)==null){
                i++;
                j--;
                continue;
            }                
            else if(level.get(i)==null || level.get(j)==null)
                return false;
                
            if(level.get(i).val != level.get(j).val){
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
    
}
