/*
Mohith and Rohith are good friends, They are used to chat very often.
Mohith is lazy to type the complete word, so he find a way to shorten the words.
For example,if the original word is "banana", he type it as "ba2[na]".

Can you help Rohith, to find the original word from the shorten word he received from Mohith .

NOTE: You may assume that the input string is always valid and does not contain any digits. 
No white spaces, brackets are well-formed.

Example-1:
Input:	  ba2[na]
Output: banana

Example-2:
Input:     2[takita]
Output:  takitatakita

Example-3:
Input:     3[3[sa]2[ri]]
Output:  sasasaririsasasaririsasasariri

Example-4:
Input:     abc3[cd]xyz
Output:  abccdcdcdxyz
*/

import java.util.*;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if ( ch == '[') {
                intStack.push(k);
                strStack.push(cur);
                cur = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder tmp = cur;
                cur = strStack.pop();
                for (k = intStack.pop(); k > 0; --k) cur.append(tmp);
            } else cur.append(ch);
        }
        return cur.toString();
    }
	
	public static void main(String args[] ) {
		Scanner sc = new Scanner(System.in);
		String word=sc.next();
		System.out.println(decodeString(word));
	 } 
}