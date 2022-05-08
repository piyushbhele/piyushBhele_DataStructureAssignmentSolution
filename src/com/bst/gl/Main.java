package com.bst.gl;

public class Main {
    Node node;
    Node prev = null;
    Node newHead = null;

    void traverse(Node root) {
        if (root == null) {
            return;
        }
        // loop till left leaf
        traverse(root.left);
        Node rightNode = root.right;
        //  Node leftNode = root.left;

        // update new head to new root
        if (newHead == null) {
            newHead = root;
            root.left = null;
            prev = root;
        } else {
            //update the right of the predecessor also the predecessor
            prev.right = root;
            root.left = null;
            prev = root;
        }
        traverse(rightNode);
    }

    void traverse1(Node root) {
        //traverse till leaf
        if (root == null) {
            return;
        }
        System.out.println(root.value + " ");
        traverse1(root.right);
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left = new Node(55);
        tree.traverse(tree.node);
        tree.traverse1(tree.newHead);
    }
}
