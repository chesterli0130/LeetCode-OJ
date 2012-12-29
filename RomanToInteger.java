/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/

import java.util.HashMap;

public class Solution {

    public static HashMap<Character, Integer> setupMap(){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;    
    }

    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        HashMap<Character, Integer> map = setupMap();
        int num=0;
        
        for(int i=0; i<s.length()-1; i++){
            char current = s.charAt(i);
            char next = s.charAt(i+1);
            
            //in roman numeral, the former number alway be larger than the latter number
            //if not, the number would be the deduct part of next number
            if(map.get(current) < map.get(next)){ 
                num -= map.get(current);
            }else{
                num += map.get(current);
            }
        }
        char last = s.charAt(s.length()-1);
        num += map.get(last);
        
        return num;
    }
}
