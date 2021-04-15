/*
Given a string S in encoded form, and  an integer array indices[] of string length.

You need to find the decoded form of String S, 
by moving each character at ith position in S, to indices[i] position in decoded string.
and then print the decoded string.

Input Format:
-------------
Line-1 -> A String S, enocded string of length L
Line-2 -> L space separated integers indices[], where 0 <=indices[i] < L 

Output Format:
--------------
Print a String, decoded string.


Sample Input-1:
---------------
aeilmmor
6 1 5 7 2 0 3 4

Sample Output-1:
----------------
memorial

Explanation:
---------------
Given String, aeilmmor
					6 1 5 7 2 0 3 4
after shifting,	memorial


Sample Input-2:
---------------
aidin
4 3 2 0 1

Sample Output-2:
----------------
india

Explanation-2:
---------------
Given String, aidin
					4 3 2 0 1
after shifting,	india

*/

import java.util.*;

class DecodedString {
    public String decodedString(String s, int[] in) {
        char[] c = new char[in.length];
        for(int i = 0; i < in.length; i++)
            c[in[i]] = s.charAt(i);
        return new String(c);
    }
	
	public static void main(String args[] ) {
		Scanner sc = new Scanner(System.in);
		String S=sc.nextLine();
		String[] sarr=sc.nextLine().split(" ");
		int[] array=new int[sarr.length];
		for(int i=0;i<sarr.length;i++)
			array[i]=Integer.parseInt(sarr[i]);
		System.out.println(new DecodedString().decodedString(S,array));
	}
	
}