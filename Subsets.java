/*
Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

public class Solution {
    
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<ArrayList<Integer>> result = subsets(S, 0);
        
        for(ArrayList<Integer> list: result){
            Collections.sort(list);
        }
        return result;
    }
    
    public ArrayList<ArrayList<Integer>> subsets(int[] S, int index){
        ArrayList<ArrayList<Integer>> set = null;
        
        if(index==S.length){
            set = new ArrayList<ArrayList<Integer>>();
            set.add(new ArrayList<Integer>());
        }else{
            int n = S[index];
            set = subsets(S, index+1);
            ArrayList<ArrayList<Integer>> more = new ArrayList<ArrayList<Integer>>();
            
            for(ArrayList<Integer> list: set){
                ArrayList<Integer> newList = new ArrayList<Integer>();
                newList.addAll(list);
                newList.add(n);
                more.add(newList);
            }
            set.addAll(more);
        }
        
        return set;
    }
}
