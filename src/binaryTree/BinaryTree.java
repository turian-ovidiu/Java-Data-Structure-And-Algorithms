package binaryTree;

/**
 * In computer science, a binary tree is a tree data structure in which each node has at most two children,
 * which are referred to as the left child and the right child.
 * In computing, binary trees are seldom used solely for their structure.
 * Much more typical is to define a labeling function on the nodes, which associates some value to each node.
 * Binary trees labelled this way are used to implement binary search trees and binary heaps,
 * and are used for efficient searching and sorting.
 */
public class BinaryTree {

    Node root;

    /**
     * This method add a node to the tree.
     * @param key the key of the node.
     * @param name the name of the node.
     */
    public void addNode(int key, String name) {
        // Create a new Node and initialize it
        Node newNode = new Node(key, name);

        if (root == null) {
            root = newNode;
        } else {
            // Set root as the Node we will start
            // with as we traverse the tree
            Node focusNode = root;
            // Future parent for our new Node
            Node parent;

            while (true) {
                // root is the top parent so we start
                // there
                parent = focusNode;

                // Check if the new node should go on
                // the left side of the parent node
                if (key < focusNode.key) {
                    // Switch focus to the left child
                    focusNode = focusNode.leftChild;

                    // If the left child has no children
                    if (focusNode == null) {
                        // then place the new node on the left of it
                        parent.leftChild = newNode;
                        return;
                    }

                    // If we get here put the node on the right
                } else {
                    focusNode = focusNode.rightChild;

                    // If the right child has no children
                    if (focusNode == null) {
                        // then place the new node on the right of it
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }

    }


    /**
     * This method traverse the tree in order. All nodes are visited in ascending order.
     * Recursion is used to go to one node and then go to its child nodes and so forth.
     * @param focusNode the node we want to focus.
     */
    public void inOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);
        }
    }


    /**
     * This method traverse the tree in pre order state.
     * @param focusNode the node we want to focus.
     */
    public void preOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {
            System.out.println(focusNode);
            preOrderTraverseTree(focusNode.leftChild);
            preOrderTraverseTree(focusNode.rightChild);
        }
    }


    /**
     *  This method traverse the tree in post order state.
     * @param focusNode the node we want to focus.
     */
    public void postOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {
            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }


    /**
     * This method find a node with a specific key and return it.
     * @param key the key we want to find.
     * @return the node with the specific key.
     */
    public Node findNode(int key) {
        // Start at the top of the tree
        Node focusNode = root;

        // While we haven't found the Node
        // keep looking
        while (focusNode.key != key) {
            // If we should search to the left
            if (key < focusNode.key) {
                // Shift the focus Node to the left child
                focusNode = focusNode.leftChild;
            } else {
                // Shift the focus Node to the right child
                focusNode = focusNode.rightChild;
            }

            // The node wasn't found
            if (focusNode == null) {
                System.out.print("The key was not found ");
                return null;
            }
        }

        return focusNode;
    }


    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addNode(20, "CEO");
        binaryTree.addNode(15, "General Manager");
        binaryTree.addNode(25, "Financial Director");
        binaryTree.addNode(32, "IT Director");
        binaryTree.addNode(10, "Regional Manager");
        binaryTree.addNode(5, "Team Leader");
        binaryTree.addNode(35, "Board of Directors");

        //binaryTree.inOrderTraverseTree(binaryTree.root);
        //binaryTree.preOrderTraverseTree(binaryTree.root);
        binaryTree.postOrderTraverseTree(binaryTree.root);

        System.out.println("\n" + binaryTree.findNode(10));

    }
}


/**
 * Setup the Node.
 */
class Node {

    int key;
    String name;

    Node leftChild;
    Node rightChild;

    public Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public String toString() {
        return name + " has the key " + key;
    }
}
