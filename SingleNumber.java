public class Solution {
    public int singleNumber(int[] a) {
    
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int num = 0;
        for(int n : a){
            num = num^n;
        }
        
        return num;
    }
}
