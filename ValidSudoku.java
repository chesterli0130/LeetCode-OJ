/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.
*/

public class Solution {
    
    public boolean isValidSudoku(char[][] board) {
    
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                  //check every cell which contains number
                char c = board[i][j];
                if(c!='.'){
                    if(!isValid(c, i, j, board))
                        return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean isValid(char c, int i, int j, char[][] board){
        
        //row
        for(int n=0; n<9; n++){
            if(n!=j && board[i][n] == c)    //skip itself
                return false;
        }
        
        //column
        for(int n=0; n<9; n++){
            if(n!=i && board[n][j] == c)    //skip itself
                return false;
        }
        
        int div = getDiv(i, j);
        int row = (div/3)*3;
        int col = (div%3)*3;
        //division
        for(int m=0; m<3; m++){
            for(int n=0; n<3; n++){                
                if(row+m!=i && col+n!=j && board[row+m][col+n] == c) //skip itself
                    return false;
            }
        }       
            
        return true; //all good
    }
    
    
    public int getDiv(int i, int j){
        int num = i*9 + j;
        int col;
        int row;
        
        col = num%9/3;        
        row = num/27;
        
        return row*3 + col;
    }

}
