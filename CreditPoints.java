/*
In a contest, There are N people stand in a row, at positions 0,1,2,...,N-1.
The person at i-th  position in the row, assigned a number by the organizer number[i].

Initially, each person has zero credits with them.
Your task is to find number of credits each person will earn at the end.

Credits[i]=product of all numbers from number[], except number[i].

Note: Credits can be positive ,negative or remains zero.

Input Format:
-------------
A space separated integer array, number[]

Output Format:
--------------
Print an integer array, credits[].


Sample Input:
---------------
1 2 5 7

Sample Output:
----------------
70 35 14 10


*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class CreditPoints
{
	public int[] creditPoints(int[] nums) {
        int length = nums.length;
        int[] credits = new int[length];
        credits[0] = 1;
        for (int i = 1; i < length; i++) {
            credits[i] = nums[i - 1] * credits[i - 1];
        }
		
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            credits[i] = credits[i] * R;
            R *= nums[i];
        }
        return credits;
    }
	 public static void main(String args[] ) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] numberline = str.split(" ");
		int[] nums = Arrays.asList(numberline).stream().mapToInt(Integer::parseInt).toArray();
		int[] credits=new CreditPoints().creditPoints(nums);
		for(int credit : credits)
		System.out.print( credit +" ");   
	}
}