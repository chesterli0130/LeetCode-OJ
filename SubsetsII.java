/*
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        Arrays.sort(num);
        int[] a = new int[num.length];
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        for(int len=0; len<=num.length; len++){
            subsetsWithDup(num, 0, len, a, 0, result);
        }
        return result;
    }
    
    public void subsetsWithDup(int[] num, int start, int len, int[] a, int index, ArrayList<ArrayList<Integer>> result){
        if(num.length-start < len)
            return;
        
        if(len==0){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i=0; i<index; i++){
                list.add(a[i]);
            }
            result.add(list);
            return;
        }
        
        for(int i=start; i<num.length; i++){
            if(i>start && num[i]==num[i-1]) //for same index, it cannot be put in same number
                continue;
            a[index] = num[i];
            subsetsWithDup(num, i+1, len-1, a, index+1, result);
        }
    }
}
