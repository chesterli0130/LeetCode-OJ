/*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

public class Solution {
    public int singleNumber(int[] a) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int[] bits = new int[32];
        
        for(int n : a){
            countBits(n, bits);
        }        
        int num = 0;
        for(int i=31; i>=0; i--){
            num = num << 1;
            if(bits[i]%3 != 0){
                num = num | 1;
            }                      
        }
        
        return num;
    }
    
    public void countBits(int n, int[] bits){
        for(int i=0; i<32 && n!=0; i++){
            int bit = n & 1;
            if(bit == 1){
                bits[i]++;
            }
            
            n = n>>1;            
        }
    }
}
