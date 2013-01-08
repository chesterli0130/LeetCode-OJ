/*
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
*/

public class Solution {
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] rows = new int[n];
        return solveNQueens(n, rows, 0);
    }
    
    public int solveNQueens(int n, int[] rows, int col){
        if(col == n){
            return 1;
        }else{
            int ways = 0;
            for(int i=0; i<n; i++){
                if(valid(col, i, rows)){
                    rows[col] = i;
                    ways += solveNQueens(n, rows, col+1);
                }
            }
            return ways;
        }
    }
    
    public boolean valid(int col, int row, int[] rows){
        for(int i=0; i<col; i++){
            if(rows[i]==row)
                return false;
            
            int rowDiff = Math.abs(rows[i]-row);
            int colDiff = col-i;
            if(rowDiff == colDiff)
                return false;
        }
        return true;
    }
}

