public class Solution {
    
    public int firstMissingPositive(int[] a) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        
        for(int i=0; i<a.length; i++){
            //if a[i] is in range [1,n] and a[i] is not in correct position and two swapped number are not equal
            while((a[i]<=a.length && a[i]>0) && i+1!=a[i] && a[a[i]-1]!=a[i]){
                swap(a, i, a[i]-1);
            }
        }   
    
        for(int i=0; i<a.length; i++){
            if(a[i]!=i+1)
                return i+1;
        }
        
        return a.length+1;
    }    
    
    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
}

