/*Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
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
 
/*Construct tree by in order*/
public class Solution {
    class Wrapper{
        ListNode node;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = length(head); 
        Wrapper w = new Wrapper();
        w.node = head;
        return sortedListToBST(w, 0, len-1);
    }
    
    public TreeNode sortedListToBST(Wrapper w, int start, int end) {
        if(start>end)
            return null;
        
        int mid = start+(end-start)/2;
        
        TreeNode left = sortedListToBST(w, start, mid-1);
        
        TreeNode n = new TreeNode(w.node.val);
        w.node = w.node.next;
        
        TreeNode right = sortedListToBST(w, mid+1, end);
        
        n.left = left;
        n.right = right;
        return n;
    }
    
    public int length(ListNode head){
        if(head==null)
            return 0;
        ListNode runner=head;
        int count=0;
        while(runner!=null && runner.next!=null){
            runner=runner.next.next;
            count++;    
        }
        if(runner==null)
            return count*2;
        else
            return count*2+1;
    }
}
