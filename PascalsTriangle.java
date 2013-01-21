/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class Solution {
    
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<numRows; i++){
            ArrayList<Integer> level = new ArrayList<Integer>();
            if(i==0){
                level.add(1);
            }else{
                level.add(1);
                
                ArrayList<Integer> lastLevel = result.get(i-1);
                for(int j=0; j<lastLevel.size()-1; j++){
                    level.add(lastLevel.get(j) + lastLevel.get(j+1));
                }
                
                level.add(1);
            }
            
            result.add(level);
        }
        
        return result;
    }
    
}
