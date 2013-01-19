/*
There are two sorted arrays A and B of size m and n respectively. 
Find the median of the two sorted arrays. 
The overall run time complexity should be O(log (m+n)).
*/

/*O(N)*/
public class Solution {
    
    public double findMedianSortedArrays(int a[], int b[]) {
        
        int len = a.length + b.length;
        int num = (len/2) + 1;    
        
        int mid1=0, mid2=0;
        int i=0, j=0;
        int count=0;
        
        while(count<num){
            mid1=mid2;
            
            if(i==a.length){                
                mid2=b[j];
                j++;
            }else if(j==b.length){
                mid2=a[i];
                i++;                
            }else if(a[i] > b[j]){
                mid2=b[j];
                j++;
            }else{
                mid2=a[i];
                i++;
            }
            
            count++;
        }
        
        if(len%2==1){    //odd number
            return (double)mid2;
        }else{
            return ((double)mid1 + (double)mid2)/2.0;
        }
    }   
}

