/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int m = matrix.length;
        
        if(m==0)
            return result;
            
        int n = matrix[0].length;
        
        spiralOrder(matrix, m, n, 0, result);
        
        return result;
    }
    
    public void spiralOrder(int[][] matrix, int m, int n, int layer, ArrayList<Integer> result){
        if(m==0 || n==0){
            return;
        }else if(m==1){
            for(int i=0; i<n; i++){    //the last row
                result.add(matrix[layer][layer+i]);
            }
        }else if(n==1){    //the last column
            for(int i=0; i<m; i++){
                result.add(matrix[layer+i][layer]);
            }
        }else{
            int rStart = layer, rEnd = layer+m-1;
            int cStart = layer, cEnd = layer+n-1;
        
            for(int i=0; i<n-1; i++){    //top left -> top right
                result.add(matrix[rStart][cStart+i]);
            }
            
            for(int i=0; i<m-1; i++){    //top right -> bottom right
                result.add(matrix[rStart+i][cEnd]);
            }
            
            for(int i=n-1; i>0; i--){    //bottom right -> bottom left
                result.add(matrix[rEnd][cStart+i]);
            }
            
            for(int i=m-1; i>0; i--){    //bottom left -> top left
                result.add(matrix[rStart+i][cStart]);
            }
            
            spiralOrder(matrix, m-2, n-2, layer+1, result);    //next layer
        }
        
    }
}
