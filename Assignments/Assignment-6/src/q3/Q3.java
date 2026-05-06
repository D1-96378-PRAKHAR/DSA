package q3;

import java.util.Scanner;

class Bst{
    private static class Node{
        int data;
        Node left, right;
        public Node(int value){
            data = value;
            left = right = null;
        }
    }

    private Node root;

    public Bst(){
        root = null;
    }

    public void insert(int value){
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value){
        if(root == null){
            root = new Node(value);
            return root;
        }
        if(value < root.data){
            root.left = insertRec(root.left, value);
        } else if(value > root.data){
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    public void inorder(){
        inorderRec(root);
    }

    private void inorderRec(Node root){
        if(root == null){
            return;
        }
        inorderRec(root.left);
        System.out.print(root.data + " ");
        inorderRec(root.right);

    }

    // find the level of a given node in BST
    public int findLevel(Node node, int value, int level) {
        if (node == null) {
            return -1; // Value not found
        }
        if (node.data == value) {
            return level; // Return the level of the found node
        }
        
        if(value < node.data) {
            return findLevel(node.left, value, level + 1); // Search in left subtree
        } else {
            return findLevel(node.right, value, level + 1); // Search in right subtree
        }
    }

    public int getLevel(int value) {
        return findLevel(root, value, 0); // Start from level 0
    }

    public int getDepth(int value) {
        return findLevel(root, value, 0); // Depth is the same as level in this context
    }
}

public class Q3 {
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
        System.out.print("\nEnter value to find level/depth : ");
        int value = sc.nextInt();
        int level = tree.getLevel(value);
        int depth = tree.getDepth(value);
        if (level != -1) {
            System.out.println("Level of node with value " + value + " is: " + level);
            System.out.println("Depth of node with value " + value + " is: " + depth);
        } else {
            System.out.println("Value " + value + " not found in the BST.");
        }
        sc.close();
    }
}