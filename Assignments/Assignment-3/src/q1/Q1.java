package q1;

import java.util.Stack;

public class Q1 {
	public static int calculate(int op1, char opr, int op2) {
		switch(opr) {
		case '+':	return op1 + op2;
		case '-':	return op1 - op2;
		case '*':	return op1 * op2;
		case '/':	return op1 / op2;
		case '%':	return op1 % op2;
		case '$':	return (int)Math.pow(op1, op2);
		}
		return 0;
	}
	
	public static int evaluatePostfix(String expr) {
		// create stack to push operands
		Stack<Integer> st = new Stack<Integer>();
		//1. traverse from left to right
		for(int i = 0 ; i < expr.length() ; i++) {
			//2. extract character at ith index
			char element = expr.charAt(i);
			//3. if element is operand, push it on stack
			if(Character.isDigit(element))
				st.push(element - '0');	// to convert into number
			//4. if element is operator
			else {
				//5. pop two elements from stack
				int op2 = st.pop();
				int op1 = st.pop();
				//6. perform operation
				int res = calculate(op1, element, op2);
				//7. push result on stack
				st.push(res);
			}
		}
		//8. if expression is finished, then pop result from stack and return
		return st.pop();		
	}
	
	public static int evaluatePrefix(String expr) {
		// create stack to push operands
		Stack<Integer> st = new Stack<Integer>();
		//1. traverse from right to left
		for(int i = expr.length()-1 ; i >= 0 ; i--) {
			//2. extract character at ith index
			char element = expr.charAt(i);
			//3. if element is operand, push it on stack
			if(Character.isDigit(element))
				st.push(element - '0');	// to convert into number
			//4. if element is operator
			else {
				//5. pop two elements from stack
				int op1 = st.pop();
				int op2 = st.pop();
				//6. perform operation
				int res = calculate(op1, element, op2);
				//7. push result on stack
				st.push(res);
			}
		}
		//8. if expression is finished, then pop result from stack and return
		return st.pop();		
	}

	public static void main(String[] args) {
		
		String postfix = "734*3/+4+5-";
		
		System.out.println("Postfix : " + postfix);
		int result = evaluatePostfix(postfix);
		System.out.println("Result : " + result);
		
		String prefix = "-++8/*35426";
		
		System.out.println("Prefix : " + prefix);
		result = evaluatePrefix(prefix);
		System.out.println("Result : " + result);
		
		
	}
}
