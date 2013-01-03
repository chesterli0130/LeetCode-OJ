/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/

/*Use hash set to check duplicate result effectively.*/
/*It works, but I don't think it is good idea.*/
public class Solution {
    
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<ArrayList<Integer>> temp = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        boolean[] has = new boolean[num.length];
        int[] a = new int[num.length];
        permute(num, has, a, 0, temp);
        
        for(ArrayList<Integer> list: temp){
            result.add(list);
        }
        return result;
    }
    
    public void permute(int[] num, boolean[] has, int[] a, int index, HashSet<ArrayList<Integer>> result) {
        if(index == num.length){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int n: a)
                list.add(n);
            if(!result.contains(list))
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
