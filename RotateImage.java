/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/

public class Solution {
    
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int n = matrix.length;
        
        for(int layer=0; layer<n/2; layer++){
            int start=layer;
            int end=n-layer-1;
            
            for(int offset=0; offset<end-start; offset++){
                int temp = matrix[start][start+offset];
                matrix[start][start+offset] = matrix[end-offset][start];
                matrix[end-offset][start] = matrix[end][end-offset];
                matrix[end][end-offset] = matrix[start+offset][end];
                matrix[start+offset][end] = temp;
            }
            
        }
    }
    
}

