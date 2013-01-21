/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/


/*Space: O(k), level k has k elements*/
public class Solution {
    
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for(int i=0; i<=rowIndex; i++){
            
            int pre = 1; //1
            
            for(int j=1; j<result.size(); j++){               
                int num = result.get(j);
                result.set(j, pre+num);
                pre = num;
            }
            
            result.add(pre); //1           
        }
        
        return result;
    }
    
}
