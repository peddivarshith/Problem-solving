/*Kiran is playing with strings and its subsequences.
A subsequence can be formed from a string by deleting some characters 
(may be string itself)

Kiran has given two strings S and T, 
your task to form T by concatenating the subsequences of S  

Return the minimum number of subsequences required to form T.
If the task is impossible, return -1 .

Input Format:
-------------
Line-1 -> Two strings S and T

Output Format:
--------------
Print an integer as result.


Sample Input-1:
---------------
abc abcbc

Sample Output-1:
----------------
2

Explanation: 
------------
T = "abcbc" can be formed by "abc" and "bc",
which are subsequences of S = "abc".


Sample Input-2:
---------------
abc acdbc

Sample Output-2:
----------------
-1

Explanation: 
------------
string T cannot be constructed from the
subsequences of string S due to the character "d" in string T.
*/

import java.util.*;
class subsequence{
    public static void main(String [] args){
        Scanner s=new Scanner(System.in);
        String s1=s.next();
        String s2=s.next();
        int poi2=0;
        int count=0;
        while(poi2<s2.length()){
            int poi1=0;
            int presentindex=poi2;
            while(poi1<s1.length() && poi2<s2.length()){
                if(s1.charAt(poi1)==s2.charAt(poi2)){
                    poi1++;
                    poi2++;
                }
                else{
                    poi1++;
                }
            }
            if(poi2==presentindex){
                count=-1;
                break;
            }
            
            else count++;
        }
        System.out.println(count);
    }
}