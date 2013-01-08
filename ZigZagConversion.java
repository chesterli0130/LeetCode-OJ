/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class Solution {
    
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(nRows==1 || s==null)
            return s;
        
        ArrayList<ArrayList<Character>> result = new ArrayList<ArrayList<Character>>();
        for(int i=0; i<nRows; i++){
            result.add(new ArrayList<Character>());
        }
        
        
        int direct=-1;
        int level=0;
        
        for(int i=0; i<s.length(); i++){
            if(level==nRows-1 || level==0){
                direct *= -1;
            }
            
            result.get(level).add(s.charAt(i));
            level += direct;
        }
        
        StringBuilder buff = new StringBuilder();
        for(ArrayList<Character> list: result){
            for(char c: list){
                buff.append(c);
            }
        }
        
        return buff.toString();
        
    }
}
