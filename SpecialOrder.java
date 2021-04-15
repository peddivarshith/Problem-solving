/*
You will be given the matrix of size R*C,

You have to return the matrix in special order as shown in the sample tescases.
 

Input Format:
-------------
Line-1 -> Two integers R and C, size of matrix.
Next R-Lines -> C space separated integers

Output Format:
--------------
Print R-Lines -> C space separated integers, in special order.


Sample Input-1:
---------------
3 3
1 2 3
4 5 6
7 8 9

Sample Output-1:
----------------
1 2 3
6 9 8
7 4 5

Sample Input-2:
---------------
3 4
1 2 3 4
5 6 7 8
9 10 11 12

Sample Output-2:
----------------
1 2 3 4
8 12 11 10
9 5 6 7

*/

import java.util.*;

public class SpecialOrder {
    public ArrayList<Integer> specialOrder(int[][] matrix) {
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if (matrix.length == 0) {
            return res;
        }
        
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            
            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;
            
            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            
            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }
        
        return res;
    }
	
	public static void main(String args[] ) {
		Scanner scan = new Scanner(System.in);
		int R=scan.nextInt();
		int C=scan.nextInt();      

		int[][] matrix=new int[R][C];
		for(int i=0; i<R; i++)
		{
			for(int j=0; j<C; j++)
			{
			   matrix[i][j] = scan.nextInt();
			}
		}
		ArrayList<Integer> result= new SpecialOrder().specialOrder(matrix);
		for(int i=0,k=0; i<R; i++)
		{
			for(int j=0; j<C; j++)
			{
				System.out.print(result.get(k)+" ");
				k++;
			}
			System.out.println();
		}
	}
}