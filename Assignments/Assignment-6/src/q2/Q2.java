package q2;

import java.util.Scanner;

class Bst {
	private static class Node {
		int data;
		Node left, right;

		public Node(int value) {
			data = value;
			left = right = null;
		}
	}

	private Node root;

	public Bst() {
		root = null;
	}

	public void insert(int value) {
		root = insertRec(root, value);
	}

	private Node insertRec(Node root, int value) {
		if (root == null) {
			root = new Node(value);
			return root;
		}
		if (value < root.data) {
			root.left = insertRec(root.left, value);
		} else if (value > root.data) {
			root.right = insertRec(root.right, value);
		}
		return root;
	}

	// Perform insertion iteratively
	public void insertIterative(int value) {
		Node newNode = new Node(value);
		if (root == null) {
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while (current != null) {
			parent = current;
			if (value < current.data) {
				current = current.left;
			} else if (value > current.data) {
				current = current.right;
			} else {
				return;
			}
		}
		if (value < parent.data) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}
	}

	public void inorder() {
		inorderRec(root);
	}

	private void inorderRec(Node root) {
		if (root == null) {
			return;
		}
		inorderRec(root.left);
		System.out.print(root.data + " ");
		inorderRec(root.right);

	}

	// Perform binary search in BST
	public boolean search(int value) {
		return searchRec(root, value);
	}

	private boolean searchRec(Node root, int value) {
		if (root == null) {
			return false;
		}
		if (root.data == value) {
			return true;
		}
		return value < root.data ? searchRec(root.left, value) : searchRec(root.right, value);
	}
}

public class Q2 {
	public static void main(String[] args) {
		Bst tree = new Bst();
		tree.insert(50);
		tree.insert(30);
		tree.insert(70);
		tree.insert(20);
		tree.insert(40);
		tree.insert(60);
		tree.insert(80);

		System.out.println("Inorder traversal of the BST:");
		tree.inorder();

		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter value to insert iteratively : ");
		int value = sc.nextInt();
		tree.insertIterative(value);
		System.out.println("Inorder traversal after insertion:");
		tree.inorder();

		System.out.println("\nEnter value to search : ");
		int searchValue = sc.nextInt();
		if (tree.search(searchValue)) {
			System.out.println("Value " + searchValue + " found in the BST.");
		} else {
			System.out.println("Value " + searchValue + " not found in the BST.");
		}
		sc.close();
	}
}
