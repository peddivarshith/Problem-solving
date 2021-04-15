/*Mr. James professor of at Illinois state university, as a part of assignment he created a
problem statement related to strings.
He gave a String S, and asked them to design a method to 
return the longest substring in S, which is a palindrome.

NOTE: Alphabets are case sensitive
"Aa" is not considered a palindrome here.

Input Format:
-------------
A string S, consist of lowercase/uppercase letters or/and digits

Output Format:
--------------
Print a string, longest palindrome substring.


Sample Input-1:
---------------
abbbabbcbbacdb

Sample Output-1:
----------------
abbcbba


Sample Input-2:
---------------
thedivideriswide

Sample Output-2:
----------------
edivide


*/






import java.util.*;
class maximum_sub_palindrome{
    public static void main(String [] args){
        Scanner s=new Scanner(System.in);
        String str=s.next();
        int matrix[][]=new int[str.length()][str.length()];
        int maxi=1;
        String temp="";
        for(int i=0;i<str.length();i++){
            matrix[i][i]=1;
        }
        for(int i=1;i<str.length();i++){
            int x=0,y=i;
            while(x<str.length() && y<str.length()){
                if(str.charAt(x)==str.charAt(y)){
                    if(x+1<=y-1 && x+1<str.length() && y-1>=0 && matrix[x+1][y-1]==1){
                        if(maxi<(y-x+1)){
                         maxi=y-x+1;
                         temp=str.substring(x,y+1);
                        }
                        matrix[x][y]=1;
                    }
                    if(x+1>y-1){
                        matrix[x][y]=1;
                    }
                    
                }
                else{
                    matrix[x][y]=0;
                }
                x++;
                y++;
            }
        }
        System.out.println(temp);
    }
}