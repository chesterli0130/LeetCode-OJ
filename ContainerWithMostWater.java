/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/

public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int max=0;
        int i=0, j=height.length-1;
        
        //we start from two lines with the longest distance
        //for the shorter one, the maximum area it can make would be the higher one with longest distance 
        //so we don't need to check the area made by other lines with it.
        while(i<j){
            int area = Math.min(height[i], height[j])*(j-i);
            if(area > max)
                max = area;
            
            if(height[i]>height[j])
                j--;
            else
                i++;
        }
        
        return max;
    }
}

