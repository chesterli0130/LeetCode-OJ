/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/

public class Solution {
    
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
               
        String[] dirs = path.split("/");
        StringBuilder buff = new StringBuilder();
        
        Stack<String> stack = new Stack<String>();
        
        for(String s: dirs){
            if(s.equals(".")){
                continue;
            }else if(s.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }else{
                if(s.length()!=0)    //if there is no char beteween "//", then empty string ""
                    stack.push(s);
            }
        }
        
        while(!stack.isEmpty()){
            buff.insert(0, "/"+stack.pop());
        }
        
        if(buff.length()==0)
            buff.append("/");
        
        return buff.toString();
    }  
}

