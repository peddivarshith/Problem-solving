/*
Giridhar went to a bank to get 1-rupee coins for N rupees.
In the cash counter, there are unlimited CoinBags, 
each bag contains square number of coins (i.e, 1,4,9,16,...)

The clerk in the cash counter needs to provide the CoinBags,
Find the minimum number of CoinBags to give to Giridhar, whose total value equals N rupees.

Input Format:
-------------
An integer N.

Output Format:
--------------
Print an integer, minimum number of bags.


Sample Input-1:
---------------
13

Sample Output-1:
----------------
2

Explanation: 13 = 9 + 4

Sample Input-2:
---------------
21

Sample Output-2:
----------------
3

Explanation: 21 = 16+4+1.

*/

import java.util.*;

public class CoinBags {
    static List<Integer> result = new ArrayList<>();
    public int minimumCoinBags(int n) {
        if (result.size() == 0) {
            result.add(0);
        }
        while (result.size() <= n) {
            int m = result.size();
            int tempMin = Integer.MAX_VALUE;
            for (int j = 1; j * j <= m; j++) {
                tempMin = Math.min(tempMin, result.get(m - j * j) + 1);
            }
            result.add(tempMin);
        }
        return result.get(n);
    }
	
	public static void main(String args[] ) {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();     
		System.out.println(minimumCoinBags(n));
	}
}
