package q3;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public static class Solution {
		public boolean isBalanced(TreeNode root) {
			return checkBalance(root) != -1;
		}

		private int checkBalance(TreeNode node) {
			if (node == null) {
				return 0;
			}

			int leftHeight = checkBalance(node.left);
			if (leftHeight == -1) {
				return -1;
			}

			int rightHeight = checkBalance(node.right);
			if (rightHeight == -1) {
				return -1;
			}

			if (Math.abs(leftHeight - rightHeight) > 1) {
				return -1;
			}

			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
}

public class Q3 {
	public static void main(String[] args) {
		// Example usage
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		TreeNode.Solution solution = new TreeNode.Solution();
		boolean isBalanced = solution.isBalanced(root);
		System.out.println("Is the tree balanced? " + isBalanced);
	}

}
