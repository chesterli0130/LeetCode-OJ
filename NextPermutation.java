/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

public class Solution {
    
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        //find the number larger than the previous number
        int index = num.length-1;
        for(; index>0; index--){
            if(num[index] > num[index-1]){                
                break;
            }
        }
        
        //if index==0, then the array is in decreaing order
        if(index!=0){
            //find the number which is least larger than the previous number
            int minIndex=index, min=num[index];
            int n = num[index-1];
            
            for(int i=index+1; i<num.length; i++){
                if(num[i]>n && num[i]<min){
                    minIndex=i;
                    min=num[i];
                }
            }
            
            swap(num, index-1, minIndex);
        }
        
        Arrays.sort(num, index, num.length);                    
    }
    
    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
}

/*O(N)*/
public class Solution {
    
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        //find the number larger than the previous number
        int index = num.length-1;
        for(; index>0; index--){
            if(num[index] > num[index-1]){                
                break;
            }
        }
        
        //if index==0, then the array is in decreaing order
        if(index!=0){
            
            int n = num[index-1];
            int i;
            //find the first element larger than n
            //note that the subarray from index to length-1 is in decreasing order
            for(i=num.length-1; i>=index; i--){
                if(num[i]>n){
                    break;
                }
            }
            
            swap(num, index-1, i);
        }
        
        //then we may just reverse 
        reverse(num, index, num.length-1);                    
    }
    
    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public void reverse(int[] a, int start, int end){
        while(start<end){
            swap(a, start, end);
            start++;
            end--;
        }
    }
    
}

