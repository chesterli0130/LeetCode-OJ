/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

public class Solution {
    
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        String[] buttons = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> result = new ArrayList<String>();
        char[] a = new char[digits.length()];
        
        letterCombinations(digits, buttons, a, 0, result);
        
        return result;
    }
    
    public void letterCombinations(String digits, String[] buttons, char[] a, int index, ArrayList<String> result){
        if(digits.length()==0){
            StringBuilder buff = new StringBuilder();
            for(int i=0; i<index; i++){
                buff.append(a[i]);
            }
            result.add(buff.toString());
        }else{
            char c = digits.charAt(0);
            String str = buttons[c-'0'];
            
            if(str.length()==0){
                letterCombinations(digits.substring(1), buttons, a, index, result);
            }else{
                for(int i=0; i<str.length(); i++){
                    a[index] = str.charAt(i);
                    letterCombinations(digits.substring(1), buttons, a, index+1, result);
                }
            }
        }
    }
    
}
