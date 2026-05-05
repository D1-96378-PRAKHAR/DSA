package q1;

public class Q1 {
	public static void insertionSortDescending(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j;

			for (j = i - 1; j >= 0; j--) {
				if (arr[j] < key) {
					arr[j + 1] = arr[j];
				} else
					break;

			}
			arr[j + 1] = key;
		}
	}

	public static void insertionSort(int arr[], int N) {
		// 1. repeat N-1 times or pick elements one by one
		for (int i = 1; i < N; i++) {
			int temp = arr[i];
			int j;
			// 2. compare picked element with left neighbors one by one
			for (j = i - 1; j >= 0; j--) {
				// 3. if left neighbor is greater then picked element then move it one position
				// ahead
				if (arr[j] > temp)
					arr[j + 1] = arr[j];
				else
					break;
			}
			// 4. insert picked element at its appropriate place
			arr[j + 1] = temp;
		}
	}

	public static void main(String[] args) {
		int arr[] = { 55, 44, 22, 66, 11, 33 };

		System.out.println("Array before sort : ");
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();

		insertionSortDescending(arr);

		System.out.println("Array after sort in descending order : ");
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}
}
