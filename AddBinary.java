/*
Given two binary strings, return their sum (also a binary string).

For example,
    a = "11"
    b = "1"
    Return "100".
*/

/*Recursive*/
public class Solution {
    public String addBinary(String a, String b) {
        if(a == null || b == null)
            return null;
        
        return add(a, b, 0);      
    }   

    public String add(String a, String b, int carry){
        if(a.length() == 0 && b.length()==0 && carry==0)
            return "";

        String digit;
        int aLen = a.length();
        int bLen = b.length();

        int sum = carry;
        if(aLen != 0){
            sum += a.charAt(aLen-1)-'0';
        }

        if(bLen != 0){
            sum += b.charAt(bLen-1)-'0';
        }

        if(sum%2 != 0){     //if sum cannot be perfectly divided by 2, (1 or 3)
            digit = "1";
        }else{      //if sum can be perfectly divided by 2, (0, 2)
            digit = "0";
        }

        String next_a = aLen == 0? a: a.substring(0, aLen-1);   //if a string has no value just pass "" to next iteration
        String next_b = bLen == 0? b: b.substring(0, bLen-1);
        int next_carry = sum>1? sum/2: 0;

        String more = add(next_a,next_b,next_carry);

        return more+digit;
        
    }
}

/*Iterative*/
public class Solution {
    
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(a==null || b==null)
            return null;
        
        if(a.length() > b.length()){
            b = padding(b, a.length()-b.length());
        }else if(a.length() < b.length()){
            a = padding(a, b.length()-a.length());
        }
        
        StringBuilder buff = new StringBuilder();
        int carry=0;
        for(int i=a.length()-1; i>=0; i--){
            int sum = carry;
            sum += a.charAt(i)-'0' + b.charAt(i)-'0';
            carry = sum/2;
            buff.insert(0, sum%2);
        }
        
        if(carry!=0)
            buff.insert(0, carry);
        
        return buff.toString();
    }
    
    public String padding(String s, int n){
        StringBuilder buff = new StringBuilder();
        
        for(int i=0; i<n; i++){
            buff.append('0');
        }
        
        buff.append(s);
        
        return buff.toString();
    }
}
