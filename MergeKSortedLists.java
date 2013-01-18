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


/* Use heap */
public class Solution {
    
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(lists.size()==0)
            return null;
        
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>(){
            public int compare(ListNode n1, ListNode n2){
            	return n1.val - n2.val;
            }
        });
        
        for(ListNode node: lists){
        	if(node!=null){
        		heap.offer(node);
            }
        }
        
        ListNode head=null, tail=null;
        while(!heap.isEmpty()){
        	ListNode n  = heap.poll();
        	if(head==null){
        		head = n;
            }else{
        	    tail.next = n;
            }
        
        	if(n.next!=null){
        		heap.add(n.next);
            }
        
            tail = n;
            tail.next = null;
        }
                
        return head;
    }
    
}
