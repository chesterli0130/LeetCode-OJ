/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 
public class Solution {
    
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<Interval> result = new ArrayList<Interval>();
        
        //sort intervals by start point
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval inter1, Interval inter2){
                return inter1.start-inter2.start;   
            }    
        });
        
        int index=0;
        
        while(index<intervals.size()){
            Interval inter = intervals.get(index);
            int last = index;
            int start=inter.start, end=inter.end;
            
            for(int i=index+1; i<intervals.size(); i++){
                if(end<intervals.get(i).start){
                    break;
                }else{
                    last = i;
                    end = Math.max(end, intervals.get(i).end);
                }
            }           
            
            result.add(new Interval(start, end));
            
            index = last+1;    
        }
        
        return result;
    }
    
}
