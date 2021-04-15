/*
In a colony drinking water is supplied through water tanks.
There is a big queue of N buckets, He need to fill all the N buckets in the queue.
The supplier can fill one bucket or two buckets at a time.

Print the number of distinct ways he can fill all the buckets.

Input Format:
-------------
An integer N, number of buckets in the queue.

Output Format:
--------------
Print the number of ways to fill all the buckets.


Sample Input-1:
---------------
2

Sample Output-1:
----------------
2

Explanation:
------------
There are two ways to fill the buckets.
1. 1 bucket + 1 bucket
2. 2 buckets


Sample Input-2:
---------------
4

Sample Output-2:
----------------
5

Explanation:
------------
There are five ways to fill the buckets.
1. 1 bucket + 1 bucket + 1 bucket + 1 bucket
2. 1 bucket + 1 bucket + 2 buckets 
3. 1 bucket + 2 buckets + 1 bucket
4. 2 buckets + 1 bucket + 1 bucket
5. 2 buckets + 2 buckets

*/

import java.util.*;

class FilltheBuckets{
	public int waysToFillTheBuckets(int n) {
		// base cases
		if(n <= 0) return 0;
		if(n == 1) return 1;
		if(n == 2) return 2;
		
		int one_step_before = 2;
		int two_steps_before = 1;
		int all_ways = 0;
		
		for(int i=2; i<n; i++){
			all_ways = one_step_before + two_steps_before;
			two_steps_before = one_step_before;
			one_step_before = all_ways;
		}
		return all_ways;
	}

	public static void main(String args[] ) {

		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		System.out.println(new FilltheBuckets().waysToFillTheBuckets(N));
	 } 
}