/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

public class Solution {
        
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(prices.length==0)    
            return 0;
        
        int min=prices[0];
        int minIndex=0;
        int start=0, end=0;
        int maxProfit=0;
        
        for(int i=1; i<prices.length; i++){
            if(prices[i]<min){
                min = prices[i];
                minIndex = i;    
            }
            
            int profit = prices[i]-min;
            if(profit>maxProfit){
                start = minIndex;
                end = i;
                maxProfit = profit;
            }
        }
        
        //find the max profit from left part or right part
        int left = maxProfitInRange(prices, 0, start-1);
        int right = maxProfitInRange(prices, end+1, prices.length-1);
        
        //find the max lost in max profit range
        int lost = maxLostInRange(prices, start+1, end-1);
        
        return maxProfit+Math.max(lost, Math.max(left, right));
        
    }
    
    public int maxProfitInRange(int[] prices, int start, int end){
        if(start>=end)
            return 0;
        
        int min=prices[start];
        int maxProfit=0;
        
        for(int i=start+1; i<=end; i++){
            if(prices[i]<min)
                min = prices[i];             
            
            int profit = prices[i]-min;
            if(profit>maxProfit){
                maxProfit = profit;
            }
        }
        
        return maxProfit;
    }
    
    public int maxLostInRange(int[] prices, int start, int end){
        if(start>=end)
            return 0;
        
        int min=prices[end];
        int maxLost=0;
        
        for(int i=end-1; i>=start; i--){
            if(prices[i]<min)
                min = prices[i];             
            
            int lost = prices[i]-min;
            if(lost>maxLost){
                maxLost = lost;
            }
        }
        
        return maxLost;
    }
    
}
