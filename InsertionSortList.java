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
    public ListNode insertionSortList(ListNode head) {
        if(head==null) {
            return null;
        }
        ListNode current = head;
        ListNode newHead = null;
        
        while(current!=null) {
            ListNode next = current.next;

            if(newHead == null) {
                newHead = current;
                current.next = null;
            } else if(current.val <= newHead.val) {
                current.next = newHead;
                newHead = current;
            } else {
                ListNode runner = newHead;
                while(runner.next!=null && runner.next.val<current.val) {
                    runner = runner.next;
                }
                current.next = runner.next;
                runner.next = current;
            }
            current = next;
        }
        return newHead;
    }
}
