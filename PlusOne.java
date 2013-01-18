/*Given a number represented as an array of digits, plus one to the number.*/

public class Solution {
    
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        int len = digits.length;
        int carry=1;    

        for(int i=len-1; i>=0; i--){
            int sum = digits[i]+carry;
            list.add(sum%10);
            carry = sum/10;
        }
        
        if(carry!=0){
            list.add(carry);
        }

        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(list.size()-1-i);
        }

        return result;

    }
    
}
