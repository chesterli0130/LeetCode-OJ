/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
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
    
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(head==null)
            return null;
        
        int len = 0;
        ListNode current = head;
        while(current.next!=null){
            current = current.next;
            len++;    
        }
        len++;
        current.next = head;        
        
        n = n%len;       
        
        for(int i=0; i<len-n; i++){
            current = current.next;
        }
        
        head = current.next;
        current.next = null;
        
        return head;
    }
    
}
