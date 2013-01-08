/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
 
/*Method 1:*/
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null)
            return null;
        
        if(head.next==null)
            return head;
        
        ListNode n1 = head;
        ListNode n2 = null;
        ListNode pre = null;    
        
        while(n1!=null && n1.next!=null){   //stop when n1 is to the end or n1 is point to the last element(odd number of elements)
            n2 = n1.next;
            
            n1.next = n2.next;  //reverse pair
            n2.next = n1;
            
            if(pre==null)
                head = n2;
            else    //Node here! After each swap, you have to relink the swaped part
                pre.next = n2;
            
            pre = n1;
            n1 = n1.next;
        }
        
        return head;
    }
} 

/*Method 2:*/
public class Solution {
    
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode h1=null, t1=null;
        ListNode h2=null, t2=null;
        boolean first=true;
        
        ListNode current = head;
        
        //separate the list into two list
        while(current!=null){
            ListNode next = current.next;
            if(first){
                if(h1==null)
                    h1 = current;
                else
                    t1.next = current;
                
                t1 = current;
                t1.next = null;
            }else{
                if(h2==null)
                    h2 = current;
                else 
                    t2.next = current;
                t2 = current;
                t2.next = null;
            }
            
            first = !first;
            current = next;
        }
        
        if(h2==null)
            return h1;
        
        head=null;
        ListNode tail = null;
        
        //Merge them
        while(h1!=null && h2!=null){
            if(head == null){
                head = h2;
                tail = head;            
            }else{
                tail.next = h2;
                tail = h2;    
            }
            h2 = h2.next;
            tail.next = h1;
            tail = h1;
            h1 = h1.next;
            tail.next = null;
        }
        
        if(h1!=null)
            tail.next = h1;
        
        return head;
    }
    
}
