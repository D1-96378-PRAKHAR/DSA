package q1;

import java.util.Scanner;

public class Q1 {
	
	public static int fibonacciRec(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        // Recursive case
        return fibonacciRec(n - 1) + fibonacciRec(n - 2);
    }

    public static int findFibonacciIter(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int a = 0, b = 1, ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = a + b;
            a = b;
            b = ans;
        }
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        n = sc.nextInt();
        int resultRec = fibonacciRec(n);
        System.out.println("The " + n + "th term of the Fibonacci series using recursion is: " + resultRec);
        int resultIter = findFibonacciIter(n);
        System.out.println("The " + n + "th term of the Fibonacci series using iteration is: " + resultIter);
        sc.close();
	}

}



