package q2;

import java.util.Scanner;

class BST {
	public static class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int value) {
			data = value;
			left = right = null;
		}
	}

	public int getData(Node node) {
		return node.data;
	}

	Node root;

	public BST() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void addNode(int value) {
		Node newNode = new Node(value);
		if (root == null) {
			root = newNode;
			return;
		}

		Node trav = root;
		while (true) {
			if (value < trav.data) {
				if (trav.left == null) {
					trav.left = newNode;
					break;
				}
				trav = trav.left;
			} else {
				if (trav.right == null) {
					trav.right = newNode;
					break;
				}
				trav = trav.right;
			}
		}
	}

	private void inOrder(Node trav) {
		if (trav == null)
			return;
		inOrder(trav.left); // L
		System.out.print(" " + trav.data); // V
		inOrder(trav.right); // R
	}

	public void inOrder() { // wrapper method
		System.out.print("In Order : ");
		inOrder(root);
		System.out.println("");
	}

	public void deleteNode(int key) {
		// 1. search node to be deleted along with its parent
		Node trav = root, parent = null;
		while (trav != null) {
			if (key == trav.data)
				break;
			parent = trav;
			if (key < trav.data)
				trav = trav.left;
			else
				trav = trav.right;
		}
		// 2. if node is not found
		if (trav == null)
			return;
		// 3. if node is found delete it
		// 3.1 if node has two child
		if (trav.left != null && trav.right != null) {
			// 1. find predecessor
			Node pred = trav.left;
			parent = trav;
			while (pred.right != null) {
				parent = pred;
				pred = pred.right;
			}
			// 2. replace value of node by its predecessor
			trav.data = pred.data;
			// 3. delete predecessor
			if (pred == parent.left)
				parent.left = pred.left;
			else if (pred == parent.right)
				parent.right = pred.left;
		}
		// 3.2 if node has single child (left child)
		else if (trav.right == null) {
			if (trav == root)
				root = trav.left;
			else if (trav == parent.left)
				parent.left = trav.left;
			else if (trav == parent.right)
				parent.right = trav.left;
		}
		// 3.3 if node has single child (right child)
		else { // if(trav.left == null) {
			if (trav == root)
				root = trav.right;
			else if (trav == parent.left)
				parent.left = trav.right;
			else if (trav == parent.right)
				parent.right = trav.right;
		}
	}
}

public class Q2 {
	public static void main(String[] args) {
		BST bst = new BST();
		bst.addNode(50);
		bst.addNode(30);
		bst.addNode(70);
		bst.addNode(20);
		bst.addNode(40);
		bst.addNode(60);
		bst.addNode(80);

		System.out.println("Inorder traversal of the BST:");
		bst.inOrder();

		// Deleting a node with two children
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter value to delete: ");
		int value = sc.nextInt();
		bst.deleteNode(value);
		System.out.println("Inorder traversal after deletion:");
		bst.inOrder();
	}
}
