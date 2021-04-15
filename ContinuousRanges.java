/*
Given a sorted list of integers, 

Your task is to find the continuous range of numbers, make them as groups
and print all the groups as show in the sample testcases.

For example:
Given list is [ 1, 2, 3 ]: 1, 2, 3 is continuous range, grouped as 1->3
Given list is [ 1, 2, 4, 5, 7 ]: 1, 2 is continuous range, grouped as 1->2, 
4,5 grouped as 4->5, 7 is left alone.

Note: List contain no duplicates.

Input Format:
-------------
Line-1 -> Space separated integers in sorted order

Output Format:
--------------
Print the list of continuous range groups.


Sample Input-1:
---------------
1 2 4 5 7

Sample Output-1:
----------------
[1->2, 4->5, 7]

Explanation: 
------------
1,2 form a continuous range; 4,5 form a continuous range.


Sample Input-2:
---------------
1 2 3 5 6 7 9 10 12

Sample Output-2:
----------------
[1->3, 5->7, 9->10, 12]

Explanation: 
------------
1,2,3 form a continuous range 
5,6,7 form a continuous range
9,10 form a continuous range

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ContinuousRanges {

	public static List<String> continuousRanges(int[] nums) {
		List<String> result = new ArrayList<>();
		for (int i, j = 0; j < nums.length; ++j){
			i = j;
			// try to extend the range [nums[i], nums[j]]
			while (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
				++j;
			// put the range into the list
			if (i == j)
				result.add(nums[i] + "");
			else
				result.add(nums[i] + "->" + nums[j]);
		}
		return result;
	}
 
	public static void main(String args[] ) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String[] numberline = str.split(" ");
		int[] nums = Arrays.asList(numberline).stream().mapToInt(Integer::parseInt).toArray();

		System.out.println(summaryRanges(nums));   
		
	}
}
