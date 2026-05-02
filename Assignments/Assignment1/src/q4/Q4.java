package q4;

class SinglyLl {
	private static class Node {
		int data;
		Node next;

		public Node() {
			this.data = 0;
			this.next = null;
		}

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head;
	private int sizeLl;

	SinglyLl() {
		this.head = null;
		this.sizeLl = 0;
	}

	public Node getHead() {
		return head;
	}

	public int getSizeLl() {
		return sizeLl;
	}

	public boolean isEmpty() {
		return (head == null && this.sizeLl == 0);
	}

	public void addFirst(int val) {
		Node newNode = new Node(val);
		newNode.next = head;
		head = newNode;
		this.sizeLl++;
	}

	public void addLast(int val) {
		Node newNode = new Node(val);

		if (head == null && this.sizeLl == 0) {
			head = newNode;
			this.sizeLl++;
		} else {
			Node curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}

			curr.next = newNode;
			this.sizeLl++;
		}
	}

	public void addAtPosition(int value, int pos) {
		if (pos <= 0) {
			this.addFirst(value);
		} else if (pos >= sizeLl) {
			this.addLast(value);
		} else {
			Node newNode = new Node(value);
			Node temp = head;
			for (int i = 0; i < pos - 1; i++) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
			this.sizeLl++;
		}
	}

	public void insertSorted(int value) {
		Node newNode = new Node(value);

		if (head == null || value <= head.data) {
			newNode.next = head;
			head = newNode;
			sizeLl++;
			return;
		}

		Node trav = head;

		while (trav.next != null && trav.next.data < value) {
			trav = trav.next;
		}

		newNode.next = trav.next;
		trav.next = newNode;
		sizeLl++;
	}

	public void deleteFirst() {
		if (head == null && this.sizeLl == 0)
			return;
		head = head.next;
		this.sizeLl--;
	}

	public void deleteLast() {
		if (head == null && this.sizeLl == 0)
			return;
		else if (head.next == null) {
			head = null;
			this.sizeLl--;
		} else {
			Node trav = head;
			while (trav.next.next != null)
				trav = trav.next;
			trav.next = null;
			this.sizeLl--;
		}
	}

	public void deleteFromPosition(int pos) {
		if (head == null)
			return;

		if (pos <= 0) {
			this.deleteFirst();
		} else if (pos >= sizeLl - 1) {
			this.deleteLast();
		} else {
			Node trav = head;
			for (int i = 0; i < pos - 1; i++) {
				trav = trav.next;
			}
			trav.next = trav.next.next;
			this.sizeLl--;
		}
	}

	public void display() {
		if (this.head == null) {
			System.out.println("Linked list is Empty");
			return;
		}
		Node trav = head;
		System.out.print("List : ");
		while (trav != null) {
			System.out.print(" " + trav.data);
			trav = trav.next;
		}
		System.out.println("");
	}

	public void deleteAll() {
		head = null;
		this.sizeLl = 0;
	}

	public int search(int key) {
		Node trav = head;
		int index = 0;

		while (trav != null) {
			if (trav.data == key) {
				return index;
			}
			trav = trav.next;
			index++;
		}

		return -1;
	}

	public boolean insertBefore(int key, int value) {
		if (head == null)
			return false;

		if (head.data == key) {
			addFirst(value);
			return true;
		}

		Node trav = head;

		while (trav.next != null) {
			if (trav.next.data == key) {
				Node newNode = new Node(value);
				newNode.next = trav.next;
				trav.next = newNode;
				sizeLl++;
				return true;
			}
			trav = trav.next;
		}

		return false;
	}

	public boolean insertAfter(int key, int value) {
		Node trav = head;

		while (trav != null) {
			if (trav.data == key) {
				Node newNode = new Node(value);
				newNode.next = trav.next;
				trav.next = newNode;
				sizeLl++;
				return true;
			}
			trav = trav.next;
		}
		return false;
	}
}

public class Q4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLl list = new SinglyLl();

		list.insertSorted(30);
		list.insertSorted(10);
		list.insertSorted(20);
		list.insertSorted(40);
		list.insertSorted(25);

		list.display();
	}
}
