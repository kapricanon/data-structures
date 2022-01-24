package practice;

import org.xml.sax.ext.EntityResolver2;


public class BinarySearchTree<T extends Comparable<T>> {

    //track number of nodes in the tree
    private int nodeCount = 0;
    //handle to root node
    private Node root = null;

    private class Node {
        Node left;
        Node right;
        T element;

        public Node(Node left, Node right, T element) {
            this.left = left;
            this.right = right;
            this. element = element;
        }
    }

    //check if the BST is empty
    public boolean isEmpty() {
        return nodeCount == 0;
    }

    //Add new element in BST
    public boolean add(T element) {

        // Check if BST already contains this element
        // If it does ignore adding it
        if(contains(element)) return false;
        else {
           add(root, element);
           nodeCount++;
           return true;
        }
    }

    private Node add(Node node, T element) {

        if(node == null) {
            node = new Node(null, null, element);
        } else {
            // Pick a substree to insert
            if(element.compareTo(node.element) < 0) {
                node.left = add(node.left, element);
            } else {
                node.right = add(node.right, element);
            }
        }
        return node;
    }

    public boolean contains(T element) {
        return contains(root, element);
    }

    // Check if BST contains an element
    // Returns true if it does
    public boolean contains(Node node, T element) {

        // if the element we need to find is null
        // then return false
        if(element == null) return false;

        int cmp = element.compareTo(node.element);

        // Dig into the left subtree because the value we're
        // looking for is smaller than the current value
        if (cmp < 0) return contains(node.left, element);
        
        // Dig into the right subtree because the value we're
        // looking for is greater than the current value
        else if (cmp > 0) return contains(node.right, element);

        // We found the node so return true
        else return true;
        
    }

    public int height() {
        return height(root);
    }

    public int height(Node element) {        
        if(element == null) return 0;
        // Find out and pick the max between left & right subtree nodes
        // And add 1 to find the height
        return Math.max(height(element.left), height(element.right)) + 1; 
    }
    
    public boolean remove(T element) {

        if(element == null) return false;

        if(contains(element)) {
            remove(root, element);
            nodeCount--;
            return true;
        }
        return false;
    }

    private Node remove(Node node, T element) {

        int cmp = element.compareTo(node.element);

        // The node we want to remove is in the left subtree
        if(cmp < 0) {
            remove(node.left, element);
        }
        // The node we want to remove is in the right subtre
        else if (cmp > 0) {
            remove(node.right, element);
        }
        // We found the node we wish to remove
        else {
            // Find the leftmost node in the right subtree
        Node tmp = findMin(node.right);

        // Swap the data
        node.element = tmp.element;

        // Go into the right subtree and remove the leftmost node we
        // found and swapped data with. This prevents us from having
        // two nodes in our tree with the same value.
        node.right = remove(node.right, tmp.element);

        }

        return node;
    }

    private Node findMin(Node node) {
        while(node.left != null) node = node.left;
        return node;
    }

    private Node findMax(Node node) {
        while(node.right != null) node = node.right;
        return node;
    }

}
