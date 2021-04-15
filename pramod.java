/*
Pramod is working on words. He used to remove all the duplicate letters from a
word.

Pramod is given a word W. His task to remove all theduplicated letters from W,
in such a way that the resulatant word R, contains no duplicate letters and all
distinct letters from W should be there in R.and R should appear first in the 
dictionary order. 

Input Format:
-------------
A String, the word W.

Output Format:
--------------
Print a String, resulatant word R.


Sample Input-1:
---------------
cbadccb

Sample Output-1:
----------------
adcb

Sample Input-2:
---------------
silicosis

Sample Output-2:
----------------
ilcos    

*/



import java.util.*;
class pramod {
    public static void main(String [] args){
        Scanner s=new Scanner(System.in);
        String word=s.next();
        Stack<Character> stack=new Stack<>();
        int arr[]=new int[26];
        HashMap<Character,Boolean> map=new HashMap<>();
        for(int i=0;i<word.length();i++){
            map.put(word.charAt(i),false);
            arr[word.charAt(i)-'a']=i;
        }
        stack.push(word.charAt(0));
        map.put(word.charAt(0),true);
        for(int i=1;i<word.length();i++){
			char c=word.charAt(i);
			int flag=0;
            while(!stack.isEmpty() && c-'a'< stack.peek()-'a' && i<arr[stack.peek()-'a'] && map.get(c)==false){
                map.put(stack.pop(),false);
				flag=1;
            }
			if(flag==1){
				map.put(c,true);
                stack.push(c);
			}
            else if(map.get(word.charAt(i))==false){
                stack.push(word.charAt(i));
                map.put(word.charAt(i),true);
            }
        }
        StringBuilder fin=new StringBuilder();
        while(!stack.isEmpty()){
            fin.append(stack.pop());
        }
        System.out.println(fin.reverse().toString());
        
    }
}