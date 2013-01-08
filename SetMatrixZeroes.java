/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

public class Solution {
    
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    rows[i] = true;
                    cols[j] = true;
                }   
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rows[i] || cols[j]){
                    matrix[i][j]=0;
                }   
            }
        }
        
    }
    
}
