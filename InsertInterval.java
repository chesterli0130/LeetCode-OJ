/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<Interval> result = new ArrayList<Interval>();
        int newStart = newInterval.start;
        int newEnd = newInterval.end;
        boolean added = false;
        
        for(Interval v: intervals){
            if(v.end < newStart){
                result.add(v);
            }else if(v.start > newEnd){
                if(!added){
                    result.add(new Interval(newStart, newEnd));
                    added = true;
                }
                result.add(v);
            }else{
                if(v.start < newStart)
                    newStart = v.start;
                if(v.end > newEnd)
                    newEnd = v.end;
            }
        }
        if(!added){
            result.add(new Interval(newStart, newEnd));
            added = true;
        }
        
        return result;
    }
}
