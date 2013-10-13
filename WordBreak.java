/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // Find the max length string in dict
        int maxLen = 0;
        for(String str : dict) {
            maxLen = Math.max(str.length(), maxLen);
        }
        
        // dp, two conditions to set dp[i] as true, where i is end of word (exclusive)
        // 1. last end, j, which is before the start of the word is true
        // 2. the word is contained in dict
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        
        for (int end=1; end<s.length()+1; end++) {
            for (int start=Math.max(0, end-maxLen); start<end; start++) {
                if (dp[start] && dict.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}
