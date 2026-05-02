package q5;

class SinglyCircularLl {

	private static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	private Node tail;
	private int size;

	public SinglyCircularLl() {
		tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		return tail == null;
	}

	// ADD
	public void addFirst(int value) {
		Node newNode = new Node(value);

		if (isEmpty()) {
			tail = newNode;
			tail.next = tail;
		} else {
			newNode.next = tail.next;
			tail.next = newNode;
		}
		size++;
	}

	public void addLast(int value) {
		addFirst(value);
		tail = tail.next;
	}

	public void addPosition(int value, int pos) {
		if (pos <= 0) {
			addFirst(value);
		} else if (pos >= size) {
			addLast(value);
		} else {
			Node newNode = new Node(value);
			Node trav = tail.next;

			for (int i = 0; i < pos - 1; i++) {
				trav = trav.next;
			}

			newNode.next = trav.next;
			trav.next = newNode;
			size++;
		}
	}

	// DELETE

	public void deleteFirst() {
		if (isEmpty())
			return;

		if (tail.next == tail) {
			tail = null;
		} else {
			tail.next = tail.next.next;
		}
		size--;
	}

	public void deleteLast() {
		if (isEmpty())
			return;

		if (tail.next == tail) {
			tail = null;
		} else {
			Node trav = tail.next;

			while (trav.next != tail) {
				trav = trav.next;
			}

			trav.next = tail.next;
			tail = trav;
		}
		size--;
	}

	public void deletePosition(int pos) {
		if (pos <= 0) {
			deleteFirst();
		} else if (pos >= size - 1) {
			deleteLast();
		} else {
			Node trav = tail.next;

			for (int i = 0; i < pos - 1; i++) {
				trav = trav.next;
			}

			trav.next = trav.next.next;
			size--;
		}
	}

	// DISPLAY

	public void display() {
		if (isEmpty()) {
			System.out.println("List is empty");
			return;
		}

		Node head = tail.next;
		Node trav = head;

		System.out.print("List: ");
		do {
			System.out.print(trav.data + " ");
			trav = trav.next;
		} while (trav != head);

		System.out.println();
	}

	public void clear() {
		tail = null;
		size = 0;
	}

	public int size() {
		return size;
	}
}

public class Q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SinglyCircularLl list = new SinglyCircularLl();

		System.out.println("ADD FIRST ");
		list.addFirst(30);
		list.addFirst(20);
		list.addFirst(10);
		list.display();

		System.out.println("\nADD LAST");
		list.addLast(40);
		list.addLast(50);
		list.display();

		System.out.println("\nADD POSITION ");
		list.addPosition(25, 2);
		list.addPosition(5, 0);
		list.addPosition(60, 100);
		list.display();

		System.out.println("\nDELETE FIRST ");
		list.deleteFirst();
		list.display();

		System.out.println("\nDELETE LAST ");
		list.deleteLast();
		list.display();

		System.out.println("\nDELETE POSITION ");
		list.deletePosition(2);
		list.display();

		System.out.println("\nDELETE ALL ");
		list.clear();
		list.display();

		System.out.println("\nEDGE CASES ");
		list.deleteFirst();
		list.deleteLast();
		list.display();

		System.out.println("\n REUSE ");
		list.addLast(100);
		list.addFirst(50);
		list.display();

		System.out.println("Size: " + list.size());
	}

}
