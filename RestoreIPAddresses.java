/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        if(s==null)
            return result;
        String[] a = new String[4];
        restore(s, result, a, 0);
        return result;
    }
    
    public void restore(String str, ArrayList<String> result, String[] a, int index){
        if(index==4){
            if(str.length()!=0)
                return;
            StringBuffer buff = new StringBuffer();
            
            for(int i=0; i<3; i++){
                buff.append(a[i]);
                buff.append('.');
            }
            buff.append(a[3]);
            result.add(buff.toString());
        }else{
            for(int len=1; len<=3; len++){
                if(len > str.length())
                    return;
                String s = str.substring(0,len);
                if(s.length()>1 && s.charAt(0)=='0')  //if the number is not 0, it cannot start with 0
                    return;
                int n = Integer.parseInt(s);
                if(n<=255){
                    a[index] = s;
                    restore(str.substring(len), result, a, index+1);
                }
            }
        }       
    }
}
