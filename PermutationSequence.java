/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/

public class Solution {
    
    class Wrapper{
        int val=0;
    }
    
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean[] has = new boolean[n+1];
        int[] a = new int[n];
        Wrapper count = new Wrapper();
        
        return kthPermutaion(n, k, count, has, a, 0);
    }
    
    public String kthPermutaion(int n, int k, Wrapper count, boolean[] has, int[] a, int index){
        if(index==n){
            count.val++;
            if(k==count.val){
                StringBuilder buff = new StringBuilder();
                for(int num: a)
                    buff.append(num);
                return buff.toString();
            }else
                return null;
        }
        
        for(int i=1; i<=n; i++){
            if(!has[i]){
                has[i] = true;
                a[index] = i;
                
                String ret = kthPermutaion(n, k, count, has, a, index+1);
                if(ret!=null)
                    return ret;
                
                has[i] = false;
            }
        }
        
        return null;
    }
    
}
