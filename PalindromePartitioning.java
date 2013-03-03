/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/

public class Solution {
    
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        String[] a = new String[s.length()];
        partition(s, result, 0, a);
        
        return result;
    }
    
    public void partition(String s, ArrayList<ArrayList<String>> result, int index, String[] a){
        if(s.length()==0){
            ArrayList<String> list = new ArrayList<String>();
            for(int i=0; i<index; i++){
                list.add(a[i]);
            }
            result.add(list);
            return;
        }
        
        for(int i=1; i<s.length(); i++){
            if(isPalindrome(s, 0, i)){
                a[index] = s.substring(0, i);
                partition(s.length(i), result, index+1, a);
            }
        }
    }
    
    public boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        
        return true;
    }
}
