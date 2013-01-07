/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function     
        
        ListNode current=head;
        ListNode pre=null;
        ListNode start=null, end=null;
        int count=1;
        
        while(count<=n){
            ListNode next = current.next;
            
            if(start!=null){
                current.next = end;
                end = current;
            }
            
            if(m>1 && count==m-1){
                pre = current;
            }
            
            if(count==m){
                start = current;
                end = start;
            }
            
            count++;
            current = next;
        }
        
        start.next = current;
        if(pre!=null)
            pre.next = end;
        else
            head = end;
        
        return head;
    }
}
