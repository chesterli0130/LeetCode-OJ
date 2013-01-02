/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        combinationSum2(num, 0, target, new ArrayList<Integer>(), result);

        return result;
    }
    
    public void combinationSum2(int[] num, int index, int sum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result){
        if(sum<0)
            return;
        
        if(sum==0){
            Collections.sort(list);
            if(!result.contains(list))
                result.add(list);
            return;         
        }
        
        if(index==num.length)
            return;
        
        
        ArrayList<Integer> newList = new ArrayList<Integer>();
        newList.addAll(list);
        combinationSum2(num, index+1, sum, newList, result);
        newList.add(num[index]);
        combinationSum2(num, index+1, sum-num[index], newList, result);
    }
}
