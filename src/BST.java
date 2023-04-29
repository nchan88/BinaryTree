import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Nathan Chan
 * @version: 4/28/23
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));

    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        //Call to helper method.
        return findval(root, val);
    }

    public boolean findval(BSTNode current, int val)
    {
        //Base Case. If the target is larger or smaller than the max or min values in the tree then this will be triggered.
        if (current == null)
        {
            return false;
        }
        //Base case (finding the value).
        if (current.getVal() == val)
        {
            return true;
        }
        //If the number we are currently "at" is larger than the target, go left toward smaller numbers.
        if (current.getVal() > val)
        {
            return findval(current.getLeft(), val);
        }
        //If the number we are currently "at" is smaller than the target, go right toward larger numbers.
        if (current.getVal() < val)
        {
            return findval(current.getRight(), val);
        }
        return false;
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        inOrderHelper(root, nodes);
        return nodes;
    }

    public void inOrderHelper (BSTNode node, ArrayList<BSTNode> nodes) {
        //This is the base case, if the current node is null, we must return to the previous node.
        if (node == null)
        {
            return;

        }
        //Traverses left subtree.
        inOrderHelper(node.getLeft(), nodes);
        //Adds current node to the list of visited nodes.
        nodes.add(node);
        //Traverses right subtree.
        inOrderHelper(node.getRight(), nodes);
        }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        preOrderHelper(root, nodes);
        return nodes;
    }

    public void preOrderHelper (BSTNode node, ArrayList<BSTNode> nodes) {
        //This is the base case, if the current node is null, we must return to the previous node.
        if (node == null)
        {
            return;

        }
        //Adds current node to the list of visited nodes.
        nodes.add(node);
        //Traverses left subtree.
        preOrderHelper(node.getLeft(), nodes);
        //Traverses right subtree.
        preOrderHelper(node.getRight(), nodes);
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        postOrderHelper(root, nodes);
        return nodes;
    }

    public void postOrderHelper (BSTNode node, ArrayList<BSTNode> nodes) {
        //This is the base case, if the current node is null, we must return to the previous node.
        if (node == null)
        {
            return;

        }
        //Traverses left subtree.
        postOrderHelper(node.getLeft(), nodes);
        //Traverses right subtree.
        postOrderHelper(node.getRight(), nodes);
        //Adds current node to the list of visited nodes.
        nodes.add(node);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
    //Converting int value into a node that can be set on the tree.
    BSTNode node = new BSTNode(val);
    BSTNode current = root;
    //Instead of recursion, I use the while (true) loop to loop infinitely until a return statement.
    while (true)
    {
        if (val < current.getVal())
        {
            //If there is no child to the left, we have found the correct location.
            if (current.getLeft() == null)
            {
                //Sets the new node with the target value as the child to the left of the current node.
                current.setLeft(node);
                return;
            }
            //If we have not found the correct node, keep changing the current node to its child on the left.
            current = current.getLeft();
        }
        else if (val > current.getVal())
        {
            //If there is no child to the right, we have found the correct location.
            if (current.getRight() == null)
            {
                //Sets the new node with the target value as the child to the right of the current node.
                current.setRight(node);
                return;
            }
            //If we have not found the correct node, keep changing the current node to its child on the right.
            current = current.getRight();
        }
        //If val is equal to current node this will return and target will not be inserted.
        else
        {
            return;
        }

    }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
