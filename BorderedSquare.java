/*
There is a large gathering of Russian Military, all the soldiers formed as a grid of 0's and 1's.
Here, 0's indicates women soldiers, 1's indicates men soldiers.

Now, the commandant wants to find out the largest square of soldiers.
The square should contain only men soldiers on it's border.

If such largest square found, print the number of soldiers in it.
Otherwise, print 0.

Sample Input-1:
-------------------
4 5
1 1 0 0 0
0 1 1 1 1
1 0 1 0 1
0 1 1 1 1

Sample Output-1:
---------------------
9

Sample Input-2:
-------------------
2 2
1 0 
0 1

Sample Output-2:
---------------------
1

Sample Input-3:
-------------------
2 2
0 0 
0 0

Sample Output-3:
---------------------
0

*/
import java.util.*;

class BorderedSquare {
    public static int largest1BorderedSquare(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] left = new int[m][n], top = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (A[i][j] > 0) {
                    left[i][j] = j > 0 ? left[i][j - 1] + 1 : 1;
                    top[i][j] = i > 0  ? top[i - 1][j] + 1 : 1;
                }
            }
        }
        for (int l = Math.min(m, n); l > 0; --l)
            for (int i = 0; i < m - l + 1; ++i)
                for (int j = 0; j < n - l + 1; ++j)
                    if (top[i + l - 1][j] >= l &&
                            top[i + l - 1][j + l - 1] >= l &&
                            left[i][j + l - 1] >= l &&
                            left[i + l - 1][j + l - 1] >= l)
                        return l * l;
        return 0;
    }
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int r=sc.nextInt();
		int c=sc.nextInt();
		int grid[][]=new int[r][c];

		for(int i=0;i<r;i++)
			for(int j=0;j<c;j++)
				grid[i][j]=sc.nextInt();

		System.out.println( largest1BorderedSquare(grid) );
	}
}