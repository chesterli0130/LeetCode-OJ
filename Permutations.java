/*
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

public class Solution {
    
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        boolean[] has = new boolean[num.length];
        int[] a = new int[num.length];
        permute(num, has, a, 0, result);
        return result;
    }
    
    public void permute(int[] num, boolean[] has, int[] a, int index, ArrayList<ArrayList<Integer>> result) {
        if(index == num.length){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int n: a)
                list.add(n);
            result.add(list);
            return;
        }
        
        for(int i=0; i<num.length; i++){
            if(!has[i]){
                has[i] = true;
                a[index] = num[i];
                permute(num, has, a, index+1, result);
                
                has[i] = false;
            }
        }
    }
}
