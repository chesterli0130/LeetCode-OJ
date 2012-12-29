/*
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
*/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.HashMap;

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
        
        for(String s: strs){
            String key = sort(s);
            LinkedList<String> list = null;
            if(!map.containsKey(key)){
                list = new LinkedList<String>();
                map.put(key, list);
            }else{
                list = map.get(key);
            }
            list.add(s);
        }
        
        for(String key: map.keySet()){
            LinkedList<String> list = map.get(key);
            if(list.size()>1){
                for(String s: list)
                    result.add(s);
            }
        }
        
        return result;
    }
    
    public String sort(String str){
        char[] a = str.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
