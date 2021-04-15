/*
There is a set of 'N' bags contains apples.
Each bag carries few number of apples.
You need to pick 'K' bags everytime from left to right.
and find the bag which contains max number of apples 'M'.
You need to return the value fo M each time.

Bags array indicates the apples count in each bag.

Input: Bags = [1,2,3,5,4,6,8,7], and k = 3
Output: 3 5 5 6 8 8
Explanation: 

			K Bags		Max
			-----------    -----
			1 2 3			3
			2 3 5			5
			3 5 4			5
			5 4 6			6
			4 6 8			8
			6 8 7			8

Can you solve it in linear time?
*/

import java.util.*;

class SlidingWindow {	
	public static int[] maxSlidingWindow(int[] a, int k) {		
		if (a == null || k <= 0) {
			return new int[0];
		}
		int n = a.length;
		int[] r = new int[n-k+1];
		int ri = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = a[q.peek()];
			}
		}
		return r;
	}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int array[]=new int[n];

		for(int i=0;i<n;i++)
			array[i]=sc.nextInt();

		int result[]=maxSlidingWindow(array,k);
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]+" ");
	}
}