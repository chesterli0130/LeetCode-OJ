/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return result;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> current = new Stack<TreeNode>();
        Stack<TreeNode> next = new Stack<TreeNode>();
        boolean leftToRight = true;
        
        current.push(root);
        while(!current.isEmpty()){
            TreeNode n = current.pop();
            list.add(n.val);
            
            if(leftToRight){
                if(n.left!=null)
                    next.push(n.left);
                if(n.right!=null)
                    next.push(n.right);
            }else{
                if(n.right!=null)
                    next.push(n.right);
                if(n.left!=null)
                    next.push(n.left);
            }
            
            if(current.isEmpty()){
                Stack<TreeNode> temp = next;
                next = current;
                current = temp;
                result.add(list);
                list = new ArrayList<Integer>();
                leftToRight = !leftToRight;
            }           
        }
        
        return result;
    }
}
