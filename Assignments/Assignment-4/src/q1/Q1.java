package q1;

import java.util.Arrays;
import java.util.Scanner;

public class Q1 {
	public static int lassOcc(int[] arr, int elem) {
		int lastI = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (arr[i] == elem)
				lastI = i;
		}
		return lastI;
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		int[] arr = { 4, 5, 6, 45, 88, 45, 96, 88, 5, 45, 8 };
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the element you want to find the last occurance of :");
		int elem = sc.nextInt();

		System.out.println("Array : " + Arrays.toString(arr));
		System.out.println("The last occurance of the element"+elem+" is : " + lassOcc(arr, elem)+"th index.");
	}

}
