/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

/*Reference: http://blog.sina.com.cn/leetcode*/

public class Solution {
    
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int val: num)
            set.add(val);
        
        int maxLen = 0;
        for(int val: num){
            //val-1 because val is already deleted when count ascendingly
            int len = countLen(set, val, true)+countLen(set, val-1, false); 
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
    
    public int countLen(HashSet<Integer> set, int val, boolean asc){
        int count=0;
        
        while(set.contains(val)){
            count++;
            set.remove(val);
            
            if(asc) //count bigger numbers
                val++;
            else    //count smaller numbers
                val--;
        }
        
        return count;
    }
}


/*HashMap + Interval*/
public class Solution {
    
    public int longestConsecutive(int[] num) {
        HashMap<Integer, int[]> hash = new HashMap<Integer, int[]>();   
        
        int maxLen=0;
        
        for(int val: num){
            if(!hash.containsKey(val)){
                int start = val;
                int end = val;
                
                if(hash.containsKey(val-1)){
                    int[] a = hash.get(val-1);
                    start = a[0];
                }
                if(hash.containsKey(val+1)){
                    int[] a = hash.get(val+1);
                    end = a[1];
                }
                
                hash.put(val, new int[]{start, end});
                
                //renew the interval of start and end
                if(start!=val)
                    hash.put(start, new int[]{start, end});
                if(end!=val)
                    hash.put(end, new int[]{start, end});

                
                int len = end-start+1;
                maxLen = Math.max(len, maxLen);
            }
        }
        
        return maxLen;
    }
}
