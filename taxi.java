/*UBER driver has a vehicle, daily he used go in only one direction.
Capacity of the vehicle is S (no of seats except driver seat), 

Given a list of N bookings, booking[i]= [ num_customers, pickup, drop ].
booking indicates, number of customers to pick up, and pick up, droping points.

Initially the vehicle is empty.

Return true if and only if it is possible to pick up and drop off all customers 
of all bookings.

Input Format:
-------------
Line-1 -> Two integers N and S, number of bookings and number of seats in the vehicle.
Next N Lines -> three space separated integers, num_customers, pickup point, 
                dropping point

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
2 5
2 1 5
3 3 7

Sample Output-1:
----------------
true


Sample Input-2:
---------------
2 4
2 1 5
3 3 7

Sample Output-2:
----------------
false


Sample Input-3:
---------------
3 11
3 2 7
3 7 9
8 3 9

Sample Output-3:
----------------
true
*/

import java.util.*;
class taxi{
    public static void main(String [] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int seats=s.nextInt();
        int arr[][]=new int[n][3];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            arr[i][0]=s.nextInt();
            arr[i][1]=s.nextInt();
            arr[i][2]=s.nextInt();
            max=Math.max(max,arr[i][2]);
        }
        
        int route[]=new int[max+1];
        for(int i=0;i<n;i++){
            route[arr[i][1]]+=arr[i][0];
            route[arr[i][2]]-=arr[i][0];
        }
        int flag=0;
        for(int i=0;i<max+1;i++){
            if(seats-route[i]>=0)seats-=route[i];
            else{
                flag=1;
                break;
            }
        }
        System.out.println(flag==0);
        
    }
}