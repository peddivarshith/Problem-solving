/*
In an institution there is a special keyboard.
It contains only one row of 26-keys, keys[]

The order of keys will be given, You need to findout the time taken to type a word.

The rules to find the time is as follows:
Initially you will be at first key .i.e, keys[0].
To type a character, you have to move to a key having desired character, key[j].
Time taken to type the character from key at ith index to key at jth index is |i - j|.

NOTE: You have to use only one finger to type the word.
*/
import java.util.*;

class SingleRow
{
    public static int calculateTime(String keyboard, String word) 
    {
        int[] index = new int[26];
        for (int i = 0; i < keyboard.length(); ++i)
        {
            index[keyboard.charAt(i) - 'a'] = i;
        }
        
        int sum = 0;
        int last = 0;
        for (char c : word.toCharArray())
        {
            sum += Math.abs(index[c - 'a'] - last);
            last = index[c - 'a'];
        }
        
        return sum;
    }

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String keys=sc.next();
		String word=sc.next();
		System.out.println(calculateTime(keys,word));
	}
}