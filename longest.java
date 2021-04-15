/*Ashok is given an array of integers nums.
His task is to find the longest contiguous subsequence S, 
the product of all the numbers in the subsequence should be positive.

Return the length of longest contiguous subarray.

Input Format:
-------------
Space separated integers nums[], list of numbers.

Output Format:
--------------
Print the length of the longest contiguous subsequence


Sample Input-1:
---------------
1 -1 2 -2

Sample Output-1:
----------------
4


Sample Input-2:
---------------
-1 -2 -3 0 1

Sample Output-2:
----------------
2

Explanation:
------------
0 is considered as positive number.


Sample Input-3:
---------------
1 2 3 4 -5 6  7 8

Sample Output-3:
----------------
4

*/

import java.util.*;
class longest{
    public static void main(String [] args){
        Scanner s=new Scanner(System.in);
     int arr[]=Arrays.asList(s.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
     int n=arr.length;
     int positive[]=new int[n];
     int negitive[]=new int[n];
     int maxi=0;
     for(int i=0;i<n;i++){
         if(arr[i]>0){
             if(i==0)positive[i]=1;
             else{
                 positive[i]=positive[i-1]+1;
             }
             if(i==0 || negitive[i-1]==0){
                 negitive[i]=0;
             }
             else{
                 negitive[i]=negitive[i-1]+1;
             }
         }
         else if(arr[i]==0){
             positive[i]=0;
             negitive[i]=0;
         }
         else{
             if(i==0 || negitive[i-1]==0){
                 positive[i]=0;
             }
             else{
                 positive[i]=negitive[i-1]+1;
             }
             if(i==0)negitive[i]=1;
             else {
                 negitive[i]=positive[i-1]+1;
             }
         }
            maxi=Math.max(maxi,positive[i]);
     }
     System.out.println(maxi);
    }
}