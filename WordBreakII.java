/*
Given a string s and a dictionary of words dict, 
add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/

public class Solution {
    // O(N^2)
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        int maxLen = 0;
        for(String str : dict) {
            maxLen = Math.max(str.length(), maxLen);
        }
        
        //DP: find all possible start index with the end index
	ArrayList<ArrayList<Integer>> set = new ArrayList<ArrayList<Integer>>();
	for(int i=0; i<=s.length(); i++) {
		ArrayList<Integer> starts = new ArrayList<Integer>();
		set.add(starts);
	}
		
	set.get(0).add(0); //add anything, prevent from size equals to 0	
        for (int end=1; end<=s.length(); end++) {
            for (int start=Math.max(0, end-maxLen); start<end; start++) {
                String word = s.substring(start, end);
		if (set.get(start).size()!=0 && dict.contains(word)) {          
			set.get(end).add(start);
                }
            }
        }
        
        //DFS: assemble all possible words using all pairs of start and end
	ArrayList<String> result = new ArrayList<String>();
	getStrings(s, set, s.length(), new ArrayList<String>(), result);
		
        return result;
    }
	
	public void getStrings(String s, ArrayList<ArrayList<Integer>> set, int end, ArrayList<String> arr, ArrayList<String> result) {
		
		//base case
		if(end == 0) {
			StringBuilder buff = new StringBuilder();
			for(int i=arr.size()-1; i>=0; i--) {
				buff.append(arr.get(i) + " ");
			}
			result.add(buff.toString().trim());
			return;
		}
		
		for(int start : set.get(end)) {
			String word = s.substring(start, end);
			arr.add(word);
			getStrings(s, set, start, arr, result);
			arr.remove(arr.size()-1);
		}
	}
}



