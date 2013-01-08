/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
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
        ListNode del=null;
        ListNode pre=null;
        
        while(current.next!=null){
            
            if(current.next.val == last){    //if found duplicate
                if(del==null)    //mark the fisrt duplicate node
                    del = current;
                current.next = current.next.next;    //delete the rest nodes
            }else{                
                if(del!=null){    //if there is an first duplicate node to delete
                    if(pre==null)    //removed head
                        head=del.next;
                    else    //link the rest part
                        pre.next = del.next;
                    del = null;
                }else{  
                    pre = current;
                }        
                last = current.next.val;
                current = current.next;
            }         
        }
        
        if(del!=null){
            if(pre==null)
                head=del.next;
            else
                pre.next = del.next;                    
        }
        
        return head;
        
    }
}
