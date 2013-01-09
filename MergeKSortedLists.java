/*
Merge k sorted linked lists and return it as one sorted list. 
Analyze and describe its complexity.
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
    
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode head = null;
        for(ListNode list: lists){
            head = merge(head, list);
        }
        
        return head;
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        
        ListNode head=null;
        
        if(l1.val > l2.val){
            head = l2;
            head.next = merge(l1, l2.next);
        }else{
            head = l1;
            head.next = merge(l1.next, l2);
        }
        
        return head;
    }
    
}
