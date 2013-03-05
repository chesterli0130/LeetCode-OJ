/*
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/

public class Solution {
    
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<String> visited = new HashSet<String>();
        LinkedList<String> queue = new LinkedList<String>();
        LinkedList<String> next = new LinkedList<String>();
        int count=1;
        
        visited.add(start);
        queue.add(start);
        
        while(!queue.isEmpty()){
            String str = queue.remove();         
            
            if(str.equals(end))
                return count;
            
            for(int i=0; i<str.length(); i++){
                char[] a = str.toCharArray();
                for(char c='a'; c<='z'; c++){
                    if(c!=str.charAt(i)){
                        a[i] = c;
                        String s = new String(a);
                        if(dict.contains(s) && !visited.contains(s)){
                            next.add(s);            
                            visited.add(s);             
                        }
                    }
                }
            }
            
            if(queue.isEmpty()){
                LinkedList<String> temp = queue;
                queue = next;
                next = temp;
                count++;
            }
        }
        
        return 0;
    }
    
}   
