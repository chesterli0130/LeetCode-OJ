/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
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
    
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode pre=null;
        ListNode current=head;
        int count=1;
        ListNode start=null, end=null;
        
        while(current!=null){
            ListNode next = current.next;
            
            if(start==null)
                start = current;
            
            if(count!=k){
                count++;
            }else{
                //reverse k nodes from start
                ListNode runner = start;
                end = next; //end starts from the current's next, we need to link start node to it.
                while(runner!=next){
                    ListNode n = runner.next;
                    runner.next = end;
                    end = runner;
                    runner = n;
                }
                
                if(pre==null) //we just changed head
                    head = end;
                else    //link the previous part to reversed partial list
                    pre.next = end;
                
                pre = start;    //renew pre
                start = null;
                end = null;
                count = 1;
            }
            current = next;
        }
        
        return head;
    }
    
}
