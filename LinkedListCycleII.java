/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode n1 = head;
        ListNode n2 = head;
        
        while(n1!=null && n1.next!=null) {
            n1 = n1.next.next;
            n2 = n2.next;
            if(n1 == n2) {
                break;
            }
        }
        
        if(n1==null || n1.next==null) {
            return null;
        }
        
        n2 = head;
        while(n1 != null) {
            if(n1 == n2) {
                return n1;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        
        return null;
    }
}
