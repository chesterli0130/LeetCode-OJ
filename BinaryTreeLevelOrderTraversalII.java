/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7]
  [9,20],
  [3],
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

import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
        
        if(root==null)
            return result;
            
        ArrayList<Integer> list = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        int current = 1;
        int next = 0;
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode n = queue.remove();
            list.add(n.val);
            
            if(n.left != null){
                queue.add(n.left);
                next++;
            }
            
            if(n.right != null){
                queue.add(n.right);
                next++;
            }
            
            current--;
            if(current==0){
                current = next;
                next = 0;
                stack.add(list);
                list = new ArrayList<Integer>();
            }
        }
        
        /*
            We may also,
            Collections.reverse(result);
            if we still use method of last question
        */
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        
        return result;
    }
}


