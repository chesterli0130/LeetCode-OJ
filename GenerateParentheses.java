/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/

public class Solution {
    
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        char[] a = new char[n*2];
        generateParens(a, 0, n, n, result);
        return result;
    }
    
    public void generateParens(char[] a, int index, int open, int close, ArrayList<String> result){
        if(open==0 && close==0){
            StringBuilder buff = new StringBuilder();
            for(int i=0; i<a.length; i++){
                buff.append(a[i]);
            }
            result.add(buff.toString());
            return;
        }
            
        
        if(open>0){
            a[index] = '(';
            generateParens(a, index+1, open-1, close, result);
        }
        
        if(close>open){
            a[index] = ')';
            generateParens(a, index+1, open, close-1, result);
        }
    }
}

