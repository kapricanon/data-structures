package practice;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    char data;
    Node left, right;

    public Node(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class PreOrder {

    public void preOrder(Node node) {
        if(node == null) return;
        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }
}

class InOrder {

    public void inOrder(Node node) {
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.data);        
        inOrder(node.right);
    }
}

class PostOrder {

    public void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.left);               
        postOrder(node.right);
        System.out.print(node.data);
    }
}

class LevelOrder {

    public void levelOrder(Node node) {
        int treeHeight = getTreeHeight(node);        
        for(int i = 0; i <= treeHeight; i++) {
            printNodesAtLevel(node, i+1);
        }
    }

    public void printNodesAtLevel(Node node, int level) {

        if(node == null) 
            return;
        
        if(level == 1) {
            System.out.print(node.data);
            return;
        }

        printNodesAtLevel(node.left, level-1);
        printNodesAtLevel(node.right, level-1);

    }

    public int getTreeHeight(Node node) {

        //if(node == null) return -1;
        //return Math.max(getTreeHeight(node.left), getTreeHeight(node.right)) + 1;
        if(node == null)    return -1;

        int lHeight = getTreeHeight(node.left);
        int rHeight = getTreeHeight(node.right);

        return Math.max(lHeight, rHeight) + 1;

    }
}

class LevelOrderWithQueue {

    Queue<Node> queue = new LinkedList<Node>();
    public void levelOrderWithQueue(Node node) {
        if(node == null) return;
        queue.add(node);  
        while(!queue.isEmpty()) {
            Node curr = queue.remove();
            System.out.print(curr.data);
            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right);
        }        
    }
}


public class App {
    public static void main(String[] args) {
    
       Node root = new Node('F');
       root.left = new Node('D');
       root.right = new Node('J');
       root.left.left = new Node('B');
       root.left.right = new Node('E');
       root.left.left.left = new Node('A');
       root.left.left.right = new Node('C');
       root.right.left = new Node('G');
       root.right.right = new Node('K');
       root.right.left.right = new Node('I');
       PreOrder preOrder = new PreOrder();
       System.out.println("PRE ORDER");
       preOrder.preOrder(root);
       System.out.println("=============");

       InOrder inOrder = new InOrder();
       System.out.println("IN ORDER");
       inOrder.inOrder(root);
       System.out.println("=============");

       PostOrder postOrder = new PostOrder();
       System.out.println("POST ORDER");
       postOrder.postOrder(root);
       System.out.println("=============");

       LevelOrder levelOrder = new LevelOrder();
       System.out.println("LEVEL ORDER");
       levelOrder.levelOrder(root);
       System.out.println("=============");

       LevelOrderWithQueue levelOrderWithQueue = new LevelOrderWithQueue();
       System.out.println("LEVEL ORDER With QUEUE");
       levelOrderWithQueue.levelOrderWithQueue(root);
       System.out.println("=============");
        
    }


}

/*

            F
        D       J
     B    E  G   K
   A  C       I


*/