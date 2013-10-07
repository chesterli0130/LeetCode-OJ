/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/

public class Solution {
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int len = gas.length;
        
        for(int start=0; start<len; start++){
            int tank = 0; 
            int count = 0;  // the number of stations
            int i = start;  // index
            
            while(count < len){
                tank += gas[i%len]; // fill gas
                tank -= cost[i%len];    // cost gas
                if(tank < 0)    //when cannot reach the next station
                    break;
                
                i++;
                count++;
            }
            
            if(count == len)
                return start;
            else if(start <= i%len) // start has to be increased
                start = i%len;
            else
                break;
        }
        
        return -1; // no answer
    }
    
}
