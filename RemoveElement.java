/*
Ramesh is given an array of N numbers L[] and another number K, 
Your task is to delete all the occurences of K in the L[], 
and return the length of L[] after deleting.

You should use only array L[] and Do not allocate extra space for another array.

Example:1
Input:	
	5 3			// N=5 and K=3
	1 3 2 2 3		//L[]
Output:	3

Example:2
Input:	
	10 2					// N=10 and K=3
	1 4 4 6 2 3 2 2 3 5		//L[]
Output:	7

*/
import java.util.*;

class RemoveElement {
    public static int removeElement(int A[], int elem) {
        int begin=0;
        for(int i=0;i<A.length;i++) 
            if(A[i]!=elem) 
                A[begin++]=A[i];

        return begin;
    }
	public static void main(String args[] ) {
		Scanner scan = new Scanner(System.in);
		int N=scan.nextInt();
		int Ele=scan.nextInt();      

		int[] arr=new int[N];
		for(int i=0; i<N; i++)
		   arr[i] = scan.nextInt();

		System.out.println(removeElement(arr,Ele));
	} 	
}