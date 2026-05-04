package q3;

import java.util.Arrays;
import java.util.Scanner;

public class Q3 {
	public static int binarySearchIterative(int[] arr, int key) {
		int low = 0;
		int high = arr.length - 1;
		int result = -1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] == key) {
				result = mid;
				low = mid + 1;
			} else if (arr[mid] > key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return result;
	}

	public static int binarySearchRecursive(int[] arr, int key, int low, int high) {
		if (low > high) {
			return -1;
		}

		int mid = low + (high - low) / 2;

		if (arr[mid] == key) {
			int result = binarySearchRecursive(arr, key, mid + 1, high);
			return (result != -1) ? result : mid;
		} else if (arr[mid] > key) {
			return binarySearchRecursive(arr, key, mid + 1, high);
		} else {
			return binarySearchRecursive(arr, key, low, mid - 1);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 88, 45, 45, 8, 6, 5, 4, 2 };
		System.out.println("Array : " + Arrays.toString(arr));
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the element you want to find the nth occurance of from the array:");
		int elem = sc.nextInt();
		int index = binarySearchIterative(arr, elem);
		System.out.println("Index of last occurrence of element "+elem+"in Sorted array is " + elem + " is at index: " + index);
	}
}
