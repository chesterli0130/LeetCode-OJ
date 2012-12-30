/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int[] a = new int[k];
        combine(n, 1, k, result, a, 0);
        return result;
    }
    
    public void combine(int n, int start, int k, ArrayList<ArrayList<Integer>> result, int[] a, int index){
        if(n<k)
            return;
        if(k==0){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int num: a)
                list.add(num);
            result.add(list);
            return;
        }
        
        for(int i=start; n-i+1>=k; i++){
            a[index] = i;
            combine(n, i+1, k-1, result, a, index+1);
        }
    }
}
