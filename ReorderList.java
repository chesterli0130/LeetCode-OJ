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
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        
        ListNode n1 = head;
        ListNode n2 = head;
        ListNode pre2 = null;
        
        while(n1!=null && n1.next!=null) {
            n1 = n1.next.next;
            pre2 = n2;
            n2 = n2.next;
        }
        //one element
        if(pre2==null) {
            return;
        }
        
        if(n1!=null) {
            pre2 = n2;
            n2 = n2.next;
        }
        pre2.next = null;

        n1 = head;
        n2 = reverse(n2);
        
        merge(n1, n2);
    }
    
    public void merge(ListNode n1, ListNode n2) {
        ListNode head = n1;
        ListNode end = null;
        while(n1!=null && n2!=null) {
            if(end!=null) {
                end.next = n1;
            }
            ListNode next = n1.next;
            n1.next = n2;
            end = n2;
            n1 = next;
            n2 = n2.next;
        }
        
        if(n2 == null) {
            end.next = n1;
        }
    }
    
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        while(head!=null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        
        return pre;
    }
}
