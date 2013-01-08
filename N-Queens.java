/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, 
where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> result = new ArrayList<String[]>();
        int[] rows = new int[n];
        
        solveNQueens(n, rows, 0, result);
        return result;
    }
    
    public void solveNQueens(int n, int[] rows, int col, ArrayList<String[]> result){
        if(col == n){
            String[] strs = new String[n];
            for(int i=0; i<n; i++){
                StringBuilder buff = new StringBuilder();
                for(int j=0; j<n; j++){
                    if(rows[j]==i)
                        buff.append('Q');
                    else
                        buff.append('.');
                }
                strs[i] = buff.toString();
            }
            result.add(strs);
        }else{
            for(int i=0; i<n; i++){
                if(valid(col, i, rows)){
                    rows[col] = i;
                    solveNQueens(n, rows, col+1, result);
                }
            }
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
