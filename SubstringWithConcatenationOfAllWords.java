/*
You are given a string, S, and a list of words, L, that are all of the same length. 
Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/

public class Solution {
    
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();         
        int len = L[0].length();
        int totalLen = L.length * len;
        
        for(String s: L){
            if(map.containsKey(s))
                map.put(s, map.get(s)+1);   
            else
                map.put(s, 1);                        
        }
        
        for(int start=0; S.length()-start>=totalLen; start++){
            int index = start;
            int matched = L.length;
            HashMap<String, Integer> count = new HashMap<String, Integer>();
            
            while(matched>0){
                String s = S.substring(index, index+len);
                
                if(count.containsKey(s))
                    count.put(s, count.get(s)+1);
                else
                    count.put(s, 1);
                
                if(map.containsKey(s) && count.get(s)<=map.get(s)){
                    index += len;
                    matched--;
                }else{
                    break;
                }                
            }
            
            if(matched==0)
                result.add(start);
        }
        
        return result;
    }
    
}
