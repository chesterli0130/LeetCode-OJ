/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.
*/

/*Brute force: O(N^2)*/
public class Solution {
    
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int maxArea=0;
        
        for(int i=0; i<height.length; i++){
            int left=i-1, right=i+1;
            int len=1;
            int h = height[i];    
            
            while(left>=0 && height[left]>=h){
                len++;
                left--;
            }
            while(right<height.length && height[right]>=h){
                len++;
                right++;
            }
            
            int area = len*h;
            if(area>maxArea)
                maxArea = area;            
        }
        
        return maxArea;
    }
        
}

/*Tracking the height and start index by stack*/
/*O(N)*/
public class Solution {
    
    class Pair{
        int height;
        int index;
        
        public Pair(int h, int i){
            height=h;
            index=i;
        }
    }
    
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Pair> stack = new Stack<Pair>();
        int max=0;
        
        for(int i=0; i<height.length; i++){
            int h = height[i];
            
            if(stack.isEmpty() || stack.peek().height<h){
                stack.push(new Pair(h, i));
            }else if(stack.peek().height>h){
                Pair p=null;
                while(!stack.isEmpty() && stack.peek().height>h){
                    p = stack.pop();
                    int area = (i-p.index)*p.height;
                    if(area>max)
                        max = area;
                }
                
                //store the start of new height, which is the first pair higher than it        
                stack.push(new Pair(h, p.index));
            }            
        }
        
        //all possible height and start which can construct rectangle to the end
        while(!stack.isEmpty()){
            Pair p = stack.pop();
            int area = (height.length-p.index)*p.height;
            if(area>max)
                max = area;
        }
        
        return max;
    }
    
}



