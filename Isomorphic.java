/*
Suman is playing with two strings S1 and S2. 
He wanted to check, whether S2 can be derived from S1 or not by replacing characters. 
If he can able to get S2 from S1, print true
Otherwise print false

Rule to replace the characters:
	- if a character A is replaced with another character B, 
	then all the occurrences of A in S1 should be replaced with B.
	
NOTE: You may assume both S1 and S2 have the same length.

Sample Input-1:
-------------------
paper 
title

Sample Output-1:
---------------------
true

Explanation:
----------------
'p' is replaced with 't', 'a' is with 'i', 'e' is with 'l', and 'r' with 'e'.


Sample Input-2:
-------------------
memo 
demo

Sample Output-2:
---------------------
false

*/

import java.util.*;

class Isomorphic {
     public static boolean isIsomorphic(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
     }
	 public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s1=sc.next();
		String s2=sc.next();
		System.out.println(isIsomorphic(s1,s2));
	}
}