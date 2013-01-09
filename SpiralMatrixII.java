/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int[][] a = new int[n][n];
        int count=1;
        
        for(int layer=0; layer<=n/2; layer++){
            int start = layer;
            int end = n-layer-1;
            
            for(int i=start; i<end; i++)
                a[start][i] = count++;
            
            for(int i=start; i<end; i++)
                a[i][end] = count++;
            
            for(int i=end; i>start; i--)
                a[end][i] = count++;
            
            for(int i=end; i>start; i--)
                a[i][start] = count++;
            
        }
        
        if(n%2==1)
            a[n/2][n/2] = count;
            
        return a;
    }
}
