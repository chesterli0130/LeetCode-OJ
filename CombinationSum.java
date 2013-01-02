/*Not Good*/

/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 <= a2 <= … <= ak).
The solution set must not contain duplicate combinations.


For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/

/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        combinationSum(target, candidates, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void combinationSum(int sum, int[] candidates, int index, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result){
        if(sum<0)
            return;
            
        if(sum==0){
            Collections.sort(list);
            if(!result.contains(list))
                result.add(list);
            return;
        }
        
        if(index==candidates.length)
            return;
        
        ArrayList<Integer> newList =  new ArrayList<Integer>();
        newList.add(list);
        for(int i=0; sum>=i*candidates[index]; i++){
            combinationSum(sum-i*candidates[index], candidates, index+1, newList, result);
            newList.add(candidates[index]);
        }
    }
}

/*Sort of space saving*/
import java.util.Arrays;
import java.util.ArrayList;

public class Solution {
    
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        //sort it in non-ascending order
        Arrays.sort(candidates);
        reverse(candidates);
        
        return findComb(candidates, target, 0);
    }


    public ArrayList<ArrayList<Integer>>  findComb(int[] a, int target, int index){
        ArrayList<ArrayList<Integer>> set = new ArrayList<ArrayList<Integer>>();

        //if target equals to 0, then we find a combination
        if(target == 0){
            set.add(new ArrayList<Integer>());  
            return set;
        }

        //if the index is larger than the length of the array, the combination is not right
        if(index>=a.length){
            return null;
        }

        for(int i=0; i*a[index] <= target; i++){
            ArrayList<ArrayList<Integer>> sub = findComb(a, target-i*a[index], index+1);
        
            if(sub != null){    //if not null, then this way work, adding result
                for(ArrayList<Integer> list: sub){
                    for(int n=0; n<i; n++){
                        list.add(a[index]);
                    }
                }
                set.addAll(sub);
            }
        }

        return set;
    }

    public void reverse(int[] a){
        int i=0, j=a.length-1;
        
        while(i<j){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }
   
}


