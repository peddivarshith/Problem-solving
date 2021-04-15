/*
Given a container with N+1 balls with a number print on them.
Numbers are between 0 to N, there is no repetition of numbers.

A ball is missed from the container.
Your task is to findout the ball, and return the number printed on it.

Sample Input:
----------------
4
3 0 1 4

Sample Output:
------------------
2

*/

import java.util.*;

class MissingNumber {	
	
	//bit manipulation
	public static int missingNumber(int[] nums) {
		int xor = 0, i = 0;
		for (i = 0; i < nums.length; i++) {
			xor = xor ^ i ^ nums[i];
		}

		return xor ^ i;
	}
	/*
	//Sum Method
	public int missingNumber(int[] nums) { //sum
		int len = nums.length;
		int sum = (0+len)*(len+1)/2;
		for(int i=0; i<len; i++)
			sum-=nums[i];
		return sum;
	}
	
	*/
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int array[]=new int[n];

		for(int i=0;i<n;i++)
			array[i]=sc.nextInt();

		System.out.println(  missingNumber(array)  );
	}
}