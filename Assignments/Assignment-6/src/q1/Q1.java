package q1;

class Bst {
	static class Node {
		int data;
		Node left, right;

		public Node(int value) {
			data = value;
			left = right = null;
		}
	}

	Node root;

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
}

public class Q1 {
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
	}
}
