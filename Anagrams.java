/*
There are two teams A and B with same N number of players.
Both the teams A and B have same set of jersey numbers for their players.

Both the teams stand in two lines opposite to each other from index 0...N-1.
Players from Team-A  in line-1 and Team-B in line-2.

You have to find an index mapping P, from A to B. 
A mapping P[i] = j means the jersey number of player[i] in Team-A appears in Team-B at index j.

The teams A and B may contain duplicate jersey numbers.
You need to return, lexicographically smallest order

For example, given
A = [12, 28, 46, 32, 50]
B = [50, 12, 32, 46, 28]
We should return
[1, 4, 3, 2, 0]


For example, given
A = [10, 10, 20, 20, 20]
B = [20, 10, 20, 10, 20]
We should return
[1, 3, 0, 2, 4]

*/

import java.util.*;

class Anagrams {
	 public int[] anagramMappings(int[] A, int[] B) {
		int n = A.length;
		for(int i = 0; i < n; i++) {
			A[i] = (A[i] << 8) + i;
			B[i] = (B[i] << 8) + i;
		}
		Arrays.sort(A);
		Arrays.sort(B);
		int[] ans = new int[n];
		for(int i = 0; i < n; i++)
			ans[A[i] & 0xFF] = B[i] & 0xFF;
		return ans;
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] A=new int[n];
		int[] B=new int[n];
		
		for(int i=0;i<n;i++)
			A[i]=sc.nextInt();
		
		for(int i=0;i<n;i++)
			B[i]=sc.nextInt();
		
		int result[]=new int[n];
		result=new Anagrams().anagramMappings(A, B);
		
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]+" ");
	}
}