/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order.
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/


/*O(N^3)*/
public class Solution {
    
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<ArrayList<Integer>> hash = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        Arrays.sort(num);
        
        for(int i=0; i<num.length-3; i++){
            for(int j=i+1; j<num.length-2; j++){
                
                int n1=num[i], n2=num[j];
                int left=j+1, right=num.length-1;
                
                while(left<right){
                    int sum = n1+n2+num[left]+num[right];
                    
                    if(sum==target){
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(n1);
                        list.add(n2);
                        list.add(num[left]);
                        list.add(num[right]);
                        
                        if(!hash.contains(list)){
                            result.add(list);
                            hash.add(list);
                        }
                        left++;
                        right--;
                    }else if(sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }                        
        }
        
        return result;
    }
    
}


/*Improved*/
public class Solution {

    class Pair{
        int i, j;
        
        public Pair(int a, int b){
            //store the index instead of value, 
            //avoiding choose a element more than once
            i = a;
            j = b;
        }     

        public boolean overlap(Pair p){
            return i==p.i || j==p.j || i==p.j || j==p.i;
        }
    }
    
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        HashMap<Integer, LinkedList<Pair>> map = new HashMap<Integer, LinkedList<Pair>>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        HashSet<ArrayList<Integer>> has = new HashSet<ArrayList<Integer>>();
        
        for(int i=0; i<num.length-1; i++){
            for(int j=i+1; j<num.length; j++){
                int sum = num[i]+num[j];
                
                if(map.containsKey(sum)){
                    map.get(sum).add(new Pair(i, j));    
                }else{
                    LinkedList<Pair> list = new LinkedList<Pair>();
                    list.add(new Pair(i, j));
                    map.put(sum, list);
                }
            }
        }
        
        for(int sum: map.keySet()){
            int diff = target-sum;
            if(map.containsKey(diff)){
                LinkedList<Pair> list1 = map.get(sum);
                LinkedList<Pair> list2 = map.get(diff);
                
                for(Pair p1: list1){
                    for(Pair p2: list2){
                        if(!p1.overlap(p2)){
                            ArrayList<Integer> list = new ArrayList<Integer>();
                            list.add(num[p1.i]);
                            list.add(num[p1.j]);
                            list.add(num[p2.i]);
                            list.add(num[p2.j]);
                            Collections.sort(list);
                            
                            if(!has.contains(list)){
                                result.add(list);
                                has.add(list);
                            }
                        }
                    }
                }
            }
        }
        
        return result;
    }  
}

