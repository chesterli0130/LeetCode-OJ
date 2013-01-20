/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
*/

public class Solution {

    public int maximalRectangle(char[][] matrix){
        if (matrix==null || matrix.length==0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
                
        //set up a dp matrix, numbered those element contain '1', in each column or row
        /*
            e.g.
            1 0 0 0             1 0 0 0
            1 1 0 0     =>      2 1 0 0
            0 1 1 1             0 2 1 1
            1 1 1 0             1 3 2 0
        */
        //then it becomes a 1D array problem for each element
                
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                
                if (matrix[i][j] == '1')
                    dp[i][j] = i > 0 ? dp[i-1][j] + 1 : 1;  
            }
        }
        
        int max = 0;

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                
                if(matrix[i][j] == '1'){
                    int end = j;
                    int minHeight = dp[i][j];
                    
                    //search in this row
                    while (end>=0 && matrix[i][end] == '1'){
                        minHeight = Math.min(minHeight, dp[i][end]); //find the min height
                        max = Math.max(max, minHeight*(j-end+1));  //find the largest area
                        end--;
                    }
                }
            }
        }

        return max;
    }
}

