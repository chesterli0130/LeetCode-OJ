/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null)
            return null;
        
        ListNode n1=head, n2=head;
        for(int i=0; i<n; i++){ //one more jump
            n1 = n1.next;
        }
        
        if(n1==null){   //delete head
            head = head.next;
            return head;
        }
        
        while(n1.next != null){ //for other case, we just find the node before the delete node
            n1 = n1.next;
            n2 = n2.next;
        }
        n2.next = n2.next.next;
        return head;
    }
}
