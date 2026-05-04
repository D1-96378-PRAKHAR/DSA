package q2;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {
	public static int nthOcc(int[] arr, int n, int elem) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			if (arr[i] == elem)
				n--;
			if (n == 1)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		int[] arr = { 4, 5, 6, 45, 88, 45, 96, 88, 5, 45, 8, 88, 45, 4, 88, 96 };
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the element you want to find the nth occurance of from the array:");
		int elem = sc.nextInt();

		System.out.println("Enter the occurance you want :");
		int n = sc.nextInt();

		System.out.println("Array : " + Arrays.toString(arr));
		System.out.println("The " + n + "th occurance of the element " + elem + " is at: " + nthOcc(arr, n, elem) + "th index.");
	}
}
