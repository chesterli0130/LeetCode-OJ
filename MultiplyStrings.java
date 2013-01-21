/*
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
*/

public class Solution {
    
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(num1==null || num2==null)
            return null;
        if(num1.length() < num2.length())
            return multiply(num2, num1);
        
        String result = "0";      
        
        for(int i=num2.length()-1; i>=0; i--){
            char c = num2.charAt(i);
            
            if(c=='0')  //don't need to calculate 0, avoiding such case 0000...
                continue;
                
            String num = multiply(num1, c);
            num = padding(num, num2.length()-1-i);
            result = add(result, num);
        }
        
        return result;
    }
    
    public String multiply(String num, char c){
        StringBuilder buff = new StringBuilder();
        int carry=0;
        
        for(int i=num.length()-1; i>=0; i--){
            int product = (num.charAt(i)-'0')*(c-'0');
            product += carry;
            
            carry = product/10;
            buff.insert(0, product%10);
        }
        
        if(carry!=0)
            buff.insert(0, carry);
        
        return buff.toString();
    }
    
    public String padding(String str, int num){
        StringBuilder buff = new StringBuilder();
        buff.append(str);
        for(int i=0; i<num; i++){
            buff.append('0');
        }
        
        return buff.toString();
    }
    
    public String add(String num1, String num2){
        if(num1==null)
            return num2;
        
        int i=num1.length()-1;
        int j=num2.length()-1;
        int carry=0;
        StringBuilder buff = new StringBuilder();
        
        while(i>=0 || j>=0 || carry>0){
            int sum = carry;
            
            if(i>=0){
                sum += num1.charAt(i)-'0';
                i--;
            }
            
            if(j>=0){
                sum += num2.charAt(j)-'0';
                j--;
            }
            
            carry = sum/10;
            buff.insert(0, sum%10);
        }
        
        return buff.toString();
    }
    
}

