/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.

*/


/*Similar with N*N chess Queen problem*/
/*DFS, try all valid prossiblities*/
public class Solution {
    
    class Pos{
        int i;
        int j;
        
        public Pos(int x, int y){
            i=x;
            j=y;
        }
    }

    public void solveSudoku(char[][] board) {

        ArrayList<Pos> emptys = new ArrayList<Pos>();
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    emptys.add(new Pos(i, j));    //set up a empty cell list
                }
            }
        }

        generator(board, emptys, 0);
    }
    
    public boolean generator(char[][] board, ArrayList<Pos> emptys, int index){
        
        if(index==emptys.size()){    //no empty cell
            return true;
        }
        
        for(int i=1; i<=9; i++){    //every empty cell try 1 to 9
            char c = (char)(i+'0');
            Pos p = emptys.get(index);
            
            if(isValid(c, p.i, p.j, board)){    //if valid, set it
                board[p.i][p.j] = c;    
                                               
                if(generator(board, emptys, index+1))    //if done return true
                    return true;
                else    //if not, set board back
                    board[p.i][p.j] = '.';
            }
        }
        
        return false;    //all invalid, return false
    }
    
    public boolean isValid(char c, int i, int j, char[][] board){
        int num = convert(c);
        
        //row
        for(int n=0; n<9; n++){
            if(board[i][n] == c)    
                return false;
        }
        
        //column
        for(int n=0; n<9; n++){
            if(board[n][j] == c)    
                return false;
        }
        
        //division
        int div = getDiv(i, j);
        for(int m=0; m<3; m++){
            for(int n=0; n<3; n++){
                int row = (div/3)*3;
                int col = (div%3)*3;
                if(board[row+m][col+n] == c)
                    return false;
            }
        }       
            
        return true; //all good
    }
    
    public int convert(char c){
        return (int)(c-'0');
    }
    
    public int getDiv(int i, int j){
        int num = i*9 + j;
        int col;
        int row;
        
        if(num%9 < 3){    //first three cols
            col=0;
        }else if(num%9 > 5){
            col=2;
        }else{
            col=1;
        }
        
        if(num/27 == 0){    //first three rows
            row = 0;
        }else if(num/27 ==2){
            row = 2;
        }else{
            row = 1;
        }
        
        return row*3 + col;
    }
}
