/*
Suman is interested in playing with kids,
Suman given a list of words to kids, and also two more words.

Suman asked the kids to find the minimum distance between the two words from the list of words.
Two words given may be same and they represent two individual words in the list.

Can you help the kids to findout the minimum distance between the two words from the list of words.

Note : You may assume two words are in the list.

Sample-1:
Input: practice makes you perfect
makes perfect
Output: 2

Sample-2:
Input: chef makes a cake using cake mix
cake cake
Output: 2

Sample-3:
Input: good bad worst good good bad bad
bad bad
Output: 1

 */
 
import java.util.*;

public class MinimumDistance {
	
	 public static int minimumWordDistance(String[] words, String word1, String word2) {
		 long dist = Integer.MAX_VALUE, i1 = dist, i2 = -dist;
		    boolean same = word1.equals(word2);
		    for (int i=0; i<words.length; i++) {
		        if (words[i].equals(word1)) {
		            if (same) {
		                i1 = i2;
		                i2 = i;
		            } else {
		                i1 = i;
		            }
		        } else if (words[i].equals(word2)) {
		            i2 = i;
		        }
		        dist = Math.min(dist, Math.abs(i1 - i2));
		    }
		    return (int) dist;     
     }
	 
	public static void main(String args[] ) {
		    Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			String[] wordslist = str.split(" ");
			str = sc.nextLine();
			String[] words = str.split(" ");
			String word1=words[0];
			String word2=words[1];
			System.out.println(minimumWordDistance(wordslist,word1,word2));
	 } 	
}
