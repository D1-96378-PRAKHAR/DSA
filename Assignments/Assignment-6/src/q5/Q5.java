package q5;

public class Q5 {
	public static int mode(int[] arr) {
		int maxCount = 0;
		int mode = arr[0];
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == arr[i]) {
					count++;
				}
			}
			if (count > maxCount) {
				maxCount = count;
				mode = arr[i];
			}
		}
		return mode;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 2, 3, 2 };
		System.out.println("The mode of the array is: " + mode(arr));
	}
}
