package q1;

class Heap{
	private int SIZE;
	private int arr[];
	
	public Heap(int arr[]) {
		SIZE = 9;
		this.arr = arr;
	}
	
	public void heapify() {
		//1. start with first parent from right side
		for(int i = SIZE / 2 ; i >= 1 ; i--) {
			//3. adjust position of root element
			int pi = i;
			int ci = pi * 2;
			while(ci <= SIZE) {
				//3.1 update ci by index of max child
				if((ci + 1) <= SIZE && arr[ci + 1] > arr[ci])
					ci = ci + 1;
				//3.2 if parent is already maximum than max child
				if(arr[pi] > arr[ci])
					break;
				//3.3 if parent is smaller than max child
				int temp = arr[pi];
				arr[pi] = arr[ci];
				arr[ci] = temp;
				//3.4 update ci and pi
				pi = ci;
				ci = pi * 2;
			}	
		}
	}
	
	public int deleteMax() {
		//0. if heap is empty, return
		if(SIZE == 0)
			return -1;
		
		int max = arr[1];
		
		//1. place last element of heap at root place
		arr[1] = arr[SIZE];
		//2. decremenr size of heap by one
		SIZE--;
		//3. adjust position of root element
		int pi = 1;
		int ci = pi * 2;
		while(ci <= SIZE) {
			//3.1 update ci by index of max child
			if((ci + 1) <= SIZE && arr[ci + 1] > arr[ci])
				ci = ci + 1;
			//3.2 if parent is already maximum than max child
			if(arr[pi] > arr[ci])
				break;
			//3.3 if parent is smaller than max child
			int temp = arr[pi];
			arr[pi] = arr[ci];
			arr[ci] = temp;
			//3.4 update ci and pi
			pi = ci;
			ci = pi * 2;
		}	
		
		return max;
	}
}

public class Q1 {
	public static void main(String[] args) {
        int arr[] = { 0, 7, 1, 9, 6, 2, 8, 3, 5, 4 }; // Index 0 is unused

        Heap heap = new Heap(arr);
        heap.heapify();

        System.out.println("Heap after heapification:");
        for (int i = 1; i <= 9; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("Deleting max elements:");
        for (int i = 0; i < 9; i++) {
            int max = heap.deleteMax();
            System.out.print(max + " ");
        }
    }
}
