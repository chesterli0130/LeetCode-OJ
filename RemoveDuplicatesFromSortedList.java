/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
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
    
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null)
            return null;
        
        int last=head.val;
        ListNode current=head;
        
        while(current.next!=null){
            if(current.next.val == last){
                current.next = current.next.next;
            }else{
                last = current.next.val;
                current = current.next;
            }         
        }
        
        return head;
    } 
}

