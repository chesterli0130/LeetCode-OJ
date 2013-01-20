/*
Given a triangle, find the minimum path sum from top to bottom. 
Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/


/*DP with O(n) space*/
public class Solution {
    
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int n = triangle.get(triangle.size()-1).size();
        int[] dp = new int[n];
        
        dp[0] = triangle.get(0).get(0);
        
        for(int i=1; i<triangle.size(); i++){
            ArrayList<Integer> list = triangle.get(i);
            
            for(int j=list.size()-1; j>=0; j--){
                if(j==list.size()-1){
                    dp[j] = list.get(j) + dp[j-1];
                }else if(j==0){
                    dp[j] = list.get(j) + dp[j];
                }else{
                    dp[j] = list.get(j) + Math.min(dp[j-1], dp[j]);
                }
            }
        }
        
        int min=Integer.MAX_VALUE;
        for(int num: dp){
            min = Math.min(num, min);
        }
        
        return min;
    }
    
}

/*Recursive, bad idea*/
public class Solution {
    
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int min=Integer.MAX_VALUE;
        int level=triangle.size()-1;
        int n = triangle.get(level).size()-1;

        for(int i=0; i<=n; i++){
            int sum = pathMinSum(triangle, level, i);
            min = Math.min(sum, min);
        }
                    
        return min;
    }
    
    public int pathMinSum(ArrayList<ArrayList<Integer>> triangle, int level, int index){
        if(level==0){
            return triangle.get(level).get(0);
        }        

        ArrayList<Integer> list = triangle.get(level);
                
        if(index==list.size()-1){
            return list.get(index) + pathMinSum(triangle, level-1, index-1);
        }else if(index==0){
            return list.get(index) + pathMinSum(triangle, level-1, index);
        }else{
            return list.get(index) + Math.min(pathMinSum(triangle, level-1, index), pathMinSum(triangle, level-1, index-1));
        }
            
    }
    
}


