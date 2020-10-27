//Reverse the stack using recursion

import java.util.Scanner;
import java.util.Stack;

class Solution {
	
	static Stack<Integer> stack = new Stack<Integer>();

	//To trace first element in function call stack and push it back to stack.
	public static void pushAtBottom(int b) {
		if(stack.isEmpty()) {
			stack.push(b);
		}
		else {
			int a = stack.peek();
			stack.pop();
			pushAtBottom(b);
			stack.push(a);
		}
	} 
	
	//To store the stack in function call stack using recursion.
	public static void reverseStack() {
		if(!stack.isEmpty()) {
			int a = stack.peek();
			stack.pop();
			reverseStack();
			pushAtBottom(a);
		}
	}
	public static void main(String[] args) {
		//Taking Input
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter no. of elements in stack :- ");
		int n = scanner.nextInt();
		
		System.out.println("Enter elements :- ");
		for(int i=0; i<n; i++) {
			stack.push(scanner.nextInt());
		}
		
		System.out.println("Original Stack " + stack);
		
		//Function to reverse the stack
		reverseStack();
		
		System.out.println("Reversed Stack " + stack);
		
		scanner.close();
	}

}
