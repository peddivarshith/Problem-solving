/*BCCI wants to select the group of bowlers for an upcoming test-series, you want
to choose the group with highest number of wickets, which is the sum of wickets
taken by all the bowlers in that group.

However, the bowler group is not allowed to have any disputes. 
A dispute exists if a younger bowler has strictly highest wickets than an 
older bowler. A dispute does not occur between bowlers of the same age.

You are given information of N bowlers as two lists, wickets and ages, 
where each wickets[i] and ages[i] represents the wickets and age of the i-th bowler, 
respectively, return the highest number of wickets of all possible bowler groups.

Input Format:
-------------
Line-1: An integer N, number of bowlers.
Line-2: N space separated integers, wickets[].
Line-3: N space separated integers, ages[].

Output Format:
--------------
An integer, highest number of wickets of all possible bowler groups.


Sample Input-1:
---------------
4
5 3 5 6
3 5 4 2

Sample Output-1:
----------------
10

Explanation:
------------
It is best to choose 2 bowlers of age 3 and 4. 


Sample Input-2:
---------------
5
5 3 5 6 3
2 5 4 2 1

Sample Output-2:
----------------
14

Explanation:
------------
It is best to choose 3 bowlers of age 1 and 2. 
Notice that you are allowed to choose multiple bowlers of the same age.

Sample Input-3:
---------------
5
1 3 5 10 15
1 2 3 4 5

Sample Output-3:
----------------
34

Explanation:
------------
You can choose all the bowlers.
*/


import java.util.*;
class bowlers{
    public static void main(String [] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int bollers[][]=new int[n][2];
        for(int i=0;i<n;i++)bollers[i][0]=s.nextInt();
        for(int i=0;i<n;i++)bollers[i][1]=s.nextInt();
        Arrays.sort(bollers,new Comparator<int []>(){
           public int compare(int a[],int b[]){
               if(Integer.compare(a[1],b[1])>0)return 2;
               else if(Integer.compare(a[1],b[1])==0 && Integer.compare(a[0],b[0])>0)return 2;
               else return -1;
           }
        });
        int matrix[]=new int[n];
        
        for(int i=0;i<n;i++){
            matrix[i]=Math.max(matrix[i],bollers[i][0]);
            for(int j=i+1;j<n;j++){
                if(bollers[j][1]>=bollers[i][1] && bollers[j][0]>=bollers[i][0])matrix[j]=Math.max(matrix[j],bollers[j][0]+matrix[i]);
            }
            
            }
        int maxi=matrix[0];
        for(int i=1;i<n;i++)maxi=Math.max(maxi,matrix[i]);
        
        System.out.println(maxi);
    }
}