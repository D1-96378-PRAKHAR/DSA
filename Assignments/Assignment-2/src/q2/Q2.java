package q2;
import java.util.Scanner;

public class Q2 {
	public static int gcdRec(int a, int b) {
        if (b == 0) {
            return a;
        }
        // Recursive case
        return gcdRec(b, a % b);
    }

    // Iterative method to find GCD of two numbers
    public static int gcdIter(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1, num2;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        num1 = sc.nextInt();
        System.out.print("Enter the second number: ");
        num2 = sc.nextInt();
        int resultRec = num1 > num2 ? gcdRec(num1, num2) : gcdRec(num2, num1);
        int resultIter = num1 > num2 ? gcdIter(num1, num2) : gcdIter(num2, num1);
        System.out.println("The GCD of " + num1 + " and " + num2 + " using recursion is: " + resultRec);
        System.out.println("The GCD of " + num1 + " and " + num2 + " using iteration is: " + resultIter);
        sc.close();   
	}

}
