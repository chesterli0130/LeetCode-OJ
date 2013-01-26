/*
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.
*/

public class Solution {
    
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<String> result = new ArrayList<String>();
        int start=0, end=0;       
              
        while(end<words.length){
            int len=0;
            int sum=0;
            StringBuilder buff = new StringBuilder();
            
            while(end<words.length){
                sum += words[end].length();
                len = end-start+sum;
                if(len > L)
                    break;
                    
                end++;
            }            
                      
            if(end<words.length){
                len = len-(words[end].length()+1); //minus the additional one plus space
                
                int numOfSpaces = L-len;
                int numOfSlot = end-1-start;    //!!! Note: if 0, then there is just one word
                
                int numPerSlot = numOfSlot==0? numOfSpaces: (numOfSpaces/numOfSlot)+1;  //plus one space
                int numOfExtra = numOfSlot==0? 0: numOfSpaces%numOfSlot;
                int index=start;
                
                for(int i=0; i<numOfExtra; i++){
                    buff.append(words[index]);
                    appendSpaces(buff, numPerSlot+1);                   
                    index++;
                }
                
                while(index<end-1){
                    buff.append(words[index]);
                    appendSpaces(buff, numPerSlot);
                    index++;
                }
                
                buff.append(words[index]);              
                if(numOfSlot==0){    //if only one word, append length to L
                    appendSpaces(buff, numPerSlot);
                }             
                result.add(buff.toString());
                
                start = end;
            }else{             
                int numOfSpaces = L-len;
                
                for(int i=start; i<end-1; i++){
                    buff.append(words[i]);
                    appendSpaces(buff, 1);
                }
                
                buff.append(words[end-1]);
                appendSpaces(buff, numOfSpaces);
                result.add(buff.toString());
            }
            
        }
        
        return result;
    }
    
    public void appendSpaces(StringBuilder buff, int num){
        for(int j=0; j<num; j++)
            buff.append(' ');
    }
    
}
