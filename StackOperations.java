/*
Write a program to perform the stack operations
push(), pop(), top(), and retrieving the minimum element in constant time.

The order of operations are:
1. void push(int E) -- Inset element E onto stack.
2. void pop() -- Delete the element on top of the stack.
3. int top() -- Print the top element.
4. int getMin() -- Print the minimum element in the stack.
0. to Stop the execution.

Input Format:
-------------
	-	Each Line consist of Operation number from the list [ 1, 2, 3, 4, 0 ], 
		and list of space separated parameters if any.
	for better understanding check sample testcases.
	
Output Format:
--------------
Print integers in new line.


Sample Input-1:
---------------
1 -2
1 0
1 -3
4
2
3
4
0

Sample Output-1:
----------------
-3
0
-2

*/

import java.util.*;

class StackOperations {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
	
	public static void main(String args[])
	{
			Scanner sc=new Scanner(System.in);
			StackOperations so=new StackOperations();
			int ch;
			do{
				ch=sc.nextInt();
				switch(ch)
				{
					case 1: so.push(sc.nextInt());
						break;
					case 2: so.pop();
						break;
					case 3: System.out.println(so.top());
						break;
					case 4: System.out.println(so.getMin());
						break;
				}
			}while(ch!=0);
	}
}