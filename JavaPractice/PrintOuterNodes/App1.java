package PrintOuterNodes;


class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class PrintLeftOuterNodes {

    int maxLevel = 0;

    public void printLeftOuterNodes(Node node, int maxLevel, int level) {
        
        this.maxLevel = maxLevel;
        if(node == null)  return;

        printLeftOuterNodes(node.left, maxLevel, level+1);

        if(maxLevel < level) {
            System.out.println(node.data);
            maxLevel = level;
        }
       
        //printLeftOuterNodes(node.right, level+1);

    }  

    public void printRightOuterNodes(Node node, int maxLevel, int level) {
        
        this.maxLevel = maxLevel;
        if(node == null)  return;        

        if(maxLevel < level) {
            System.out.println(node.data);
            maxLevel = level;
        }
        
        printRightOuterNodes(node.right, maxLevel, level+1);

        //printLeftOuterNodes(node.right, level+1);

    }  
}

class MaxPath {
    int maxValue;
    
    public int maxPathSum(Node root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }
    
    private int maxPathDown(Node node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.data);
        return Math.max(left, right) + node.data;
    }
}


public class App1 {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);

        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.left = new Node(9);
        root.right.left.right = new Node(10);
        root.right.left.right.right = new Node(11);

        PrintLeftOuterNodes printLeftOuterNodes = new PrintLeftOuterNodes();
        printLeftOuterNodes.printLeftOuterNodes(root, 0, 1);
        printLeftOuterNodes.printRightOuterNodes(root.right, 0, 1);

        MaxPath maxPath = new MaxPath();
        System.out.println("Max Path:");
        System.out.println(maxPath.maxPathSum(root));

        System.out.println("Test");
    }
}