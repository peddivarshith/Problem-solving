/*Given two strings S1 and S2, find if S2 can match S1 or not.

A match that is both one-to-one (an injection) and onto (a surjection), 
i.e. a function which relates each letter in string S1 to a separate and 
distinct non-empty substring in S2, where each non-empty substring in S2 
also has a corresponding letter in S1.

Return true,if S2 can match S1.
Otherwise false.

Input Format:
-------------
Line-1 -> Two strings S1 and S2

Output Format:
--------------
Print a boolean value as result.


Sample Input-1:
---------------
abab kmitngitkmitngit

Sample Output-1:
----------------
true


Sample Input-2:
---------------
aaaa kmjckmjckmjckmjc

Sample Output-2:
----------------
true

Sample Input-3:
---------------
aabb xyzabcxyzabc

Sample Output-3:
----------------
false
*/



import java.util.*;
class isomorphic1{
    private static boolean findmatch(String s1,String s2,int i,int j,HashMap<Character,String> map,HashSet<String> set){
        if(i==s1.length() && j==s2.length())return true;
        if(i>=s1.length() || j>=s2.length())return false;
        
        char present=s1.charAt(i);
        for(int k=j+1;k<=s2.length();k++){
            String word=s2.substring(j,k);
            if(!map.containsKey(present) && !set.contains(word)){
                map.put(present,word);
                set.add(word);
                if(findmatch(s1,s2,i+1,k,map,set)){
                    return true;
                }
                map.remove(present);
                set.remove(word);
            }
            else if(map.containsKey(present) && map.get(present).equals(word)){
                if(findmatch(s1,s2,i+1,k,map,set))return true;
            }
            else if(map.containsKey(present) && word.length()>map.get(present).length())return false;
        }
        return false;
    }
    private static boolean match(String s1,String s2){
        if(s1.length()==0 && s2.length()==0)return true;
        if(s1.length()==0)return false;
        HashMap<Character,String> map=new HashMap<Character,String>();
        HashSet<String> set=new HashSet<String>();
        return findmatch(s1,s2,0,0,map,set);
    }
    public static void main(String [] args){
        Scanner s=new Scanner(System.in);
        String s1=s.next();
        String s2=s.next();
        System.out.println(match(s1,s2));
    }
    
}