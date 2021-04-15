/*The Panna Diamond Fields (PDF) is in the form of a m*n grid,
Each field, contains a number of diamonds in it.
 
You can mine the diamonds in the PDF in the following way.
	- Intially, you are at first field of the grid in any row
	- You are allowed to mine through the grid either right-side, right-side-down,
	  Or right-side-up.
Your task is to find the maximum number of diamonds you can collect.

Input Format:
-------------
Line-1: Two integers M and N size of the PDF grid.
Next M lines: N space separated integers, diamonds in each row of the grid.

Output Format:
--------------
Print an integer, maximum number of diamonds.


Sample Input-1:
---------------
3 3
1 3 3
2 1 4
0 6 4

Sample Output-1:
----------------
12

Explanation:
-------------
You can mine through the PDF as follows:
2nd row 1st field -> 3rd row 2st field -> 3rd row 3rd field
2 + 6 + 4 = 12


Sample Input-2:
---------------
4 4
1 3 1 5
2 2 4 1
5 0 2 3
0 6 1 2

Sample Output-2:
----------------
16

Explanation:
-------------
You can mine through the PDF as follows:
3rd row 1st field -> 2nd row 2st field -> 2nd row 3rd field -> 1st row 4th field
OR
3rd row 1st field -> 4th row 2st field -> 3rd row 3rd field -> 3rd row 4th field

*/


import java.util.*;
class mine{
    public static void main(String [] args){
        Scanner s=new Scanner(System.in);
        int n,m;
        n=s.nextInt();
        m=s.nextInt();
        int arr[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=s.nextInt();
            }
        }
        int maxi=0;
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                int c=arr[j][i-1];
                int d=0,e=0;
                if(j-1>=0)d=arr[j-1][i-1];
                if(j+1<n)e=arr[j+1][i-1];
                arr[j][i]+=Math.max(c,Math.max(d,e));
            }
        }
        for(int i=0;i<n;i++)
            maxi=Math.max(maxi,arr[i][m-1]);
        System.out.println(maxi);
    }
}