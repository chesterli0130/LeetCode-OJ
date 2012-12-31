/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
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
 
import java.util.ArrayList;
import java.util.LinkedList;
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
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
				result.add(list);
				list = new ArrayList<Integer>();
			}
		}
		
		return result;
    }
}



