/*Few people travelling in N*N grid land.
and there are few traps set by local goons. Due to safety restrictions, 
people has to maximize the distance between the traps near to them.

You are given the current status of N*N grid containing values 0 and 1, 
where 0 represents a person and 1 represents trap, 
your task is to find a person's cell such that his/her distance to the 
nearest trap cell is maximized, and return the distance.

The distance used in this problem is the Manhattan distance: 
the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1| .

Input Format:
-------------
Line-1: An integer N, size of the square grid.
Next N lines: N space separated integers, grid[][] either 0 or 1.

Output Format:
--------------
An integer, maximum distance.


Sample Input-1:
---------------
3
1 0 1
0 0 0
1 0 1

Sample Output-1:
----------------
2

Explanation: 
------------
The person at (1, 1) is with distance 2 from all the traps.


Sample Input-2:
---------------
3
1 0 0
0 0 0
1 0 0

Sample Output-2:
----------------
3

Explanation: 
------------
The person at (1, 2) is with distance 3 from all the traps.
*/

import java.util.*;
class trap{
    public static void main(String [] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int matrix[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int m=s.nextInt();
                if(m==1)
                    matrix[i][j]=-1;
            }
        }
        for(int i=0;i<n;i++){
            int index=-1;
            for(int j=0;j<n;j++){
                if(matrix[i][j]==-1)index=j;
                if(matrix[i][j]!=-1 && index!=-1)matrix[i][j]=j-index;
            }
        }
        for(int i=0;i<n;i++){
            int index=-1;
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j]==-1)index=j;
                if(matrix[i][j]!=-1 && index!=-1){
                    if(matrix[i][j]==0)matrix[i][j]=index-j;
                    else
                    matrix[i][j]=Math.min(matrix[i][j],index-j);
                }
            }
        }
        for(int i=0;i<n;i++){
            int index=-1;
            for(int j=0;j<n;j++){
                if(matrix[j][i]==-1)index=j;
                if(matrix[j][i]!=-1 && index!=-1){
                    if(matrix[j][i]==0)matrix[j][i]=j-index;
                    else matrix[j][i]=Math.min(matrix[j][i],j-index);
                }
            }
        }
        int maxi=0;
        for(int i=0;i<n;i++){
            int index=-1;
            for(int j=n-1;j>=0;j--){
                if(matrix[j][i]==-1)index=j;
                if(matrix[j][i]!=-1 && index!=-1){
                    if(matrix[j][i]==0)matrix[j][i]=index-j;
                    
                    else matrix[j][i]=Math.min(matrix[j][i],index-j);
                }
                maxi=Math.max(maxi,matrix[j][i]);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int d=Integer.MAX_VALUE;
                int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE,c=Integer.MAX_VALUE;
                if(j+1<n && matrix[i][j+1]!=-1 && matrix[i][j+1]!=0){
                    d=matrix[i][j+1];
                }
                if(j-1>=0 && matrix[i][j-1]!=-1 && matrix[i][j-1]!=0)a=matrix[i][j-1];
                if(i+1<n && matrix[i+1][j]!=-1 && matrix[i+1][j]!=0)b=matrix[i+1][j];
                if(i-1>=0 && matrix[i-1][j]!=-1 && matrix[i-1][j]!=0)c=matrix[i-1][j];
                int take=matrix[i][j];
                int k=Math.min(a,Math.min(d,Math.min(b,c)));
                if(k!=Integer.MAX_VALUE)
                    matrix[i][j]=k+1;
                if(take!=0)matrix[i][j]=Math.min(matrix[i][j],take);
                maxi=Math.max(maxi,matrix[i][j]);
                //System.out.println(matrix[i][j]);
            }
        }
        System.out.println(maxi);
        
    }
}