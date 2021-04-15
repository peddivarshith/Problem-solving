/*

Given a sorted list of integers E[], and two integers  L and U
Where L <= E[i]  <= U.

Your task is to find the ranges, which are not present in the given list
and print all the ranges

For example:
Given list is [ 1, 2, 4, 51, 52, 53, 92, 93, 94, 95 ] and L=1 U=100: 
The ranges which are not present are [3, 5->50, 54->91, 96->100]

Note: List E contain no duplicates.

Input Format:
-------------
Line-1 -> Space separated integers in sorted order

Output Format:
--------------
Print the list of ranges.


Sample Input-1:
---------------
0 1 2 3 4 5 8 9 10
0 20

Sample Output-1:
----------------
[6->7, 11->20]


Sample Input-2:
---------------
1 2 4 51 52 53 92 93 94 95
1 100

Sample Output-2:
----------------
[3, 5->50, 54->91, 96->100]
 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MissedRanges {
	public static List<String> findMissiedRanges(int[] a, int lo, int hi) {
		List<String> res = new ArrayList<String>();

		// the next number we need to find
		int next = lo;

		for (int i = 0; i < a.length; i++) {
		// not within the range yet
		if (a[i] < next) continue;

		// continue to find the next one
		if (a[i] == next) {
		  next++;
		  continue;
		}

		// get the missing range string format
		res.add(getRange(next, a[i] - 1));

		// now we need to find the next number
		next = a[i] + 1;
		}

		// do a final check
		if (next <= hi) res.add(getRange(next, hi));

		return res;
	}

	static String getRange(int n1, int n2) {
		return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
	}
	
	public static void main(String args[] ) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String[] numbers = str.split(" ");
		int[] arr = Arrays.asList(numbers).stream().mapToInt(Integer::parseInt).toArray();
		str = br.readLine();
		String[] rangeline = str.split(" ");
		int[] range = Arrays.asList(rangeline).stream().mapToInt(Integer::parseInt).toArray();
		
		System.out.println(findMissiedRanges(arr,range[0],range[1]));
	}
}
