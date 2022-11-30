package com.mycompany.assignment08;

class Assignment08 // This should be called BST (Binary Search Tree)
{
    // Declare the Binary Search Tree
    public class Node
    {
        int value;
        Node left;
        Node right;

        public Node(int value)
        {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // Declare the root of the BST
    Node root;

    // Constructor for the root (like Lab11)
    public Assignment08()
    {
        this.root = null;
    }

    // Delete a specific node
    Node deleteNode(Node root, int key)
    {
        if (root == null)
        {
            return root;
        }

        if (key < root.value)
        {
            root.left = deleteNode(root.left, key);
        }

        else if (key > root.value)
        {
            root.right = deleteNode(root.right, key);
        }

        else
        {
            // If it found the value to delete
            if (root.left == null)
            {
                return root.right;
            }

            else if (root.right == null)
            {
                return root.left;
            }

            root.value = min(root.right);
            root.right = deleteNode(root.right, root.value);
        }
        return root;
    }
    
    // This allows the deleteNode method to replace the proper value
    int min(Node root)
    {
        int minv = root.value;
        while (root.left != null)
        {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }

    void insert(int key)
    {
        root = insertNode(root, key);
    }

    // Method to add nodes to the BST
    Node insertNode(Node root, int key)
    {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.value)
        {
            root.left = insertNode(root.left, key);
        }

        else if (key > root.value)
        {
            root.right = insertNode(root.right, key);
        }
        return root;
    }

    // Calls the deleteNode method
    void deleteKey(int key)
    {
        root = deleteNode(root, key);
    }
    
    // Calls on the print method
    void print() 
    {
        printTree(root);
    }
    
    // Method to print the tree
    void printTree(Node root) 
    {
        if (root == null) return;
        System.out.println(root.value + " ");
        printTree(root.left);
        printTree(root.right);
    }

    // Insert the values and delete 4, then print out
    public static void main(String[] args)
    {
        Assignment08 tree = new Assignment08();

        tree.insert(5);
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(7);

        tree.deleteKey(4);
        tree.print();
    }
}
