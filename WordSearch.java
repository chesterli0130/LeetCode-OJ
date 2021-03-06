/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class Solution {
    
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = board.length;
        int n = board[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(exist(board, visited, word, i, j))
                        return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean exist(char[][] board, boolean[][] visited, String word, int i, int j){
                  
        if(word.length()==0)
            return true;
            
        if(i<0 || j<0 || i>=board.length || j>=board[0].length)
            return false;
        
        if(!visited[i][j] && board[i][j] == word.charAt(0)){
            visited[i][j] = true;
            String remain = word.substring(1);
            if(exist(board, visited, remain, i+1, j) || exist(board, visited, remain, i, j+1) || 
                exist(board, visited, remain, i-1, j) || exist(board, visited, remain, i, j-1))
                return true;
                
            visited[i][j] = false;
        }
        
        return false;
    }
    
}
