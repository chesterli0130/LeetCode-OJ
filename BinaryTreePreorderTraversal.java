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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(!stack.isEmpty() || current!=null) {
            if(current != null) {
                result.add(current.val);
                if(current.right!=null) {
                    stack.push(current.right);
                }
                current = current.left;
            } else {
                current = stack.pop();
            }
        }
        return result;
    }
}
