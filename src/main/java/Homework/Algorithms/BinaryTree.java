package Homework.Algorithms;

public class BinaryTree {
    Node root;

    // Find a node
    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.key == key) {
                return current;
            } else if (current.key > key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;  // Not found
    }

    // Insert a node
    public void insert(int key, int value) {
        root = insertRecursively(root, key, value);
    }

    private Node insertRecursively(Node current, int key, int value) {
        if (current == null) {
            return new Node(key, value);
        }
        if (key < current.key) {
            current.left = insertRecursively(current.left, key, value);
        } else if (key > current.key) {
            current.right = insertRecursively(current.right, key, value);
        } else {
            // Update value if key already exists
            current.value = value;
        }
        return current;
    }

    // Delete a node by value
    public void delete(int key) {
        root = deleteRecursively(root, key);
    }

    private Node deleteRecursively(Node current, int key) {
        if (current == null) {
            return null;
        }
        if (key == current.key) {
            // Node to be deleted found
            // ... code to delete the node will go here
        } else if (key < current.key) {
            current.left = deleteRecursively(current.left, key);
        } else {
            current.right = deleteRecursively(current.right, key);
        }
        return current;
    }

    // Print the tree in-order
    public void print(Node node) {
        if (node != null) {
            print(node.left);
            System.out.print("Key: " + node.key + ", Value: " + node.value + " ");
            print(node.right);
        }
    }

    class Node {
        int key;
        int value;
        Node left;
        Node right;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(6, 60);
        binaryTree.insert(4, 40);
        binaryTree.insert(8, 80);
        binaryTree.insert(3, 30);
        binaryTree.insert(5, 50);
        binaryTree.insert(7, 70);
        binaryTree.insert(9, 90);

        System.out.println("In-Order Traversal:");
        binaryTree.print(binaryTree.root);
    }
}
