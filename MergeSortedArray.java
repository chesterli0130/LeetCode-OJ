/*
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
*/

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int len = m+n;
        
        while(m>0 && n>0){
            if(A[m-1] > B[n-1]){
                A[len-1] = A[m-1];
                m--;
            }else{
                A[len-1] = B[n-1];
                n--;
            }
            len--;
        }
        
        while(n>0){
            A[len-1] = B[n-1];
            n--;
            len--;
        }
        
    }
}

