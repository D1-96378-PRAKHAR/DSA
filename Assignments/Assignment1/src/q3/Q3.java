package q3;

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

public class Q3 {
	public static void main(String[] args) {

		SinglyLl list = new SinglyLl();

		System.out.println("===== INITIAL =====");
		list.display();

		System.out.println("\n===== ADD FIRST =====");
		list.addFirst(30);
		list.addFirst(20);
		list.addFirst(10);
		list.display();

		System.out.println("\n===== ADD LAST =====");
		list.addLast(40);
		list.addLast(50);
		list.display();

		System.out.println("\n===== ADD AT POSITION =====");
		list.addAtPosition(25, 2);
		list.display();

		System.out.println("\n===== SEARCH =====");
		System.out.println("Index of 25: " + list.search(25));
		System.out.println("Index of 100: " + list.search(100));

		System.out.println("\n===== INSERT AFTER =====");
		boolean afterResult = list.insertAfter(25, 27);
		System.out.println("Insert after 25: " + afterResult);
		list.display();

		System.out.println("\n===== INSERT BEFORE =====");
		boolean beforeResult = list.insertBefore(25, 23);
		System.out.println("Insert before 25: " + beforeResult);
		list.display();

		System.out.println("\n===== INSERT BEFORE HEAD =====");
		list.insertBefore(10, 5);
		list.display();

		System.out.println("\n===== INSERT AFTER LAST =====");
		list.insertAfter(50, 55);
		list.display();

		System.out.println("\n===== DELETE OPERATIONS =====");
		list.deleteFirst();
		list.deleteLast();
		list.deleteFromPosition(2);
		list.display();

		System.out.println("\n===== DELETE ALL =====");
		list.deleteAll();
		list.display();

		System.out.println("\n===== EDGE CASES =====");
		System.out.println("Insert after (empty): " + list.insertAfter(10, 20));
		System.out.println("Insert before (empty): " + list.insertBefore(10, 5));

	}
}
