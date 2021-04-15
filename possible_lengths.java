import java.util.*;
//eg egg
// output e g eg ge gg egg geg gge (no repetations)
class possible_lengths{
    static int count=0;
    static void get_all(int store[]){
        for(int i=0;i<26;i++){
            if(store[i]>0){
                store[i]--;
                count++;
                get_all(store);
                store[i]++;
            }
        }
    }
    public static void main(String [] args){
        Scanner s=new Scanner(System.in);
        String arr=s.next();
        int store[]=new int[26];
        for(int i=0;i<arr.length();i++)
            store[arr.charAt(i)-'A']++;
        get_all(store);
        System.out.println(count);
        
    }
}