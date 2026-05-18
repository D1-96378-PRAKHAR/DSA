package q1;

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

	public void displayInorder(Node trav) {
		if (trav == null)
			return;

		displayInorder(trav.left);
		System.out.print(trav.data + " ");
		displayInorder(trav.right);
	}


	public Node findSuccessor(Node node) {
		if (node == null)
			return null;

		// If the node has a right child, then the successor is the leftmost node in the
		// right subtree.
		if (node.right != null) {
			Node successor = node.right;
			while (successor.left != null) {
				successor = successor.left;
			}
			return successor;
		}

		// If the node does not have a right child, then the successor is one of its
		// ancestors.
		Node successor = null;
		Node ancestor = root;
		while (ancestor != node) {
			if (node.data < ancestor.data) {
				successor = ancestor; // So far this is the deepest node for which current node is in left.
				ancestor = ancestor.left;
			} else {
				ancestor = ancestor.right;
			}
		}
		return successor;
	}
}

public class Q1 {
	public static void main(String[] args) {
		BST bst = new BST();
		int value;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of nodes: ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter value: ");
			value = sc.nextInt();
			bst.addNode(value);
		}
		System.out.println("Inorder Traversal:");
		bst.displayInorder(bst.root);

		System.out.println("\nEnter value to find successor: ");
		value = sc.nextInt();
		BST.Node node = bst.findSuccessor(new BST.Node(value));
		if (node != null) {
			System.out.println("Successor of " + value + " is: " + bst.getData(node));
		} else {
			System.out.println("No successor found for " + value);
		}

		sc.close();
	}
}
