/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 
Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/

/*
Note:
1. Sign (Negative, Positive)
2. Space
3. Overflow (Integer.MAX_VALUE, Integer.MIN_VALUE)
4. Heading with 0
5. Other character
*/

public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(str==null || str.length()==0)
            return 0;
        
        boolean neg=false;
      long num=0;
		int index=0;
		
		str = str.trim();
		if(str.charAt(index)=='-'){
			index++;
			neg=true;
		}else if(str.charAt(index)=='+'){
    	    index++;   
		}
		
		for(; index<str.length(); index++){
			char c = str.charAt(index);
			if(c<'0' || c>'9')
				break;
			
			num = num*10 + (int)(c-'0');
			if(num>Integer.MAX_VALUE){	//overflow
				if(neg)
					return Integer.MIN_VALUE;
				else
					return Integer.MAX_VALUE;
			}		
		}
        
		return (int)(neg? -num: num);
    }
}

