/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
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
    
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ListNode h1=null, t1=null;
        ListNode h2=null, t2=null;
        
        while(head!=null){
            ListNode next = head.next;
            
            if(head.val<x){
                if(h1==null){
                    h1 = head;
                }else{
                    t1.next = head;
                }
                t1 = head;
                t1.next = null;
            }else{
                if(t2==null){
                    h2 = head;
                }else{
                    t2.next = head;
                }
                t2 = head;
                t2.next = null;
            }
            
            head = next;
        }
        
        if(h1==null)
            return h2;
        
        t1.next = h2;
        return h1;
    }
    
}
