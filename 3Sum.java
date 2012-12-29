/*
Given a roman numeral, convert it to an integer.
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

import java.util.HashMap;

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        Arrays.sort(num);
        
        for(int i=0; i<num.length-2; i++){
            int s = i+1;
            int e = num.length-1;
            
            if(i>0 && num[i] == num[i-1])      //for preventint same start elements
                    continue;
            
            while(s < e){
                int sum = num[i] + num[s] + num[e];
                
                if(sum == 0){
                    ArrayList<Integer> set = new ArrayList<Integer>();
                    set.add(num[i]);
                    set.add(num[s]);
                    set.add(num[e]);
                    result.add(set);
                                       
                    s++;
                    e--;
                    while(s < e){       //for preventing same elements
                        if(num[s] == num[s-1])
                            s++;
                        if(num[e] == num[e+1])
                            e--;                    
                        if(num[s] != num[s-1] && num[e] != num[e+1]){
                            break;  
                        }
                    }                                                                                                          
                }else if(sum > 0)
                    e--;
                else
                    s++;                             
            }
        }
        
        return result;
    }
}
