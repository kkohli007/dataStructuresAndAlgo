package src.geeksForGeeksProblems.easy;

import src.dataStructures.trees.BinarySearchTree;
import src.dataStructures.trees.TreeNode;

import java.util.ArrayList;

public class TreeProblems {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(3);
        bst.insert(1);
        bst.insert(4);

        bst.display();

        System.out.println(inOrder(bst.getRoot()));
        System.out.println(postOrder(bst.getRoot()));

        // Find minimum node
        BinarySearchTree bst2 = new BinarySearchTree(1);
        bst2.insert(5);
        bst2.insert(4);
        bst2.insert(6);
        bst2.insert(3);
        bst2.insert(7);
        bst2.display();

        System.out.println("Mininum value in tree: " + minValue(bst2.getRoot()));

        System.out.println("Leaves count: " + countLeaves(bst2.getRoot()));

        System.out.println("Is node 6 present " + search(bst2.getRoot(),2));


    }

    public static ArrayList<Integer> inOrder(TreeNode root) {
        ArrayList<Integer> inOrderList = new ArrayList<>();
        if(root == null)
            return inOrderList;
        return inOrderTraversalNode(root, inOrderList);
    }

    private static ArrayList<Integer> inOrderTraversalNode(TreeNode node, ArrayList<Integer> inOrderList) {
        if(node.getLeft()!=null)
        {
            inOrderTraversalNode(node.getLeft(),inOrderList);
        }
        inOrderList.add(node.getData());
        if(node.getRight()!=null)
        {
            inOrderTraversalNode(node.getRight(),inOrderList);
        }
        return inOrderList;
    }

    static int minValue(TreeNode node) {

        if(node == null)
            return -1;

        TreeNode currNode = node;
        while(currNode.getLeft()!=null)
        {
            currNode = currNode.getLeft();
        }
        return currNode.getData();

    }

    static int countLeaves(TreeNode node)
    {
        // Your code
        if(node==null)
            return 0;
        else if(node.getLeft()==null && node.getRight() == null)
            return 1;

        int sum = 0;
        if(node.getLeft()!=null)
        {
            sum = sum + countLeaves(node.getLeft());
        }
        if(node.getRight()!=null)
        {
            sum = sum + countLeaves(node.getRight());
        }

        return sum;
    }

    public static ArrayList<Integer> postOrder(TreeNode root) {
        ArrayList<Integer> postOrderList = new ArrayList<>();
        if(root == null)
            return postOrderList;
        return postOrderTraversalNode(root, postOrderList);
    }

    private static ArrayList<Integer> postOrderTraversalNode(TreeNode node, ArrayList<Integer> postOrderList) {
        if(node.getLeft()!=null)
        {
            postOrderTraversalNode(node.getLeft(),postOrderList);
        }
        if(node.getRight()!=null)
        {
            postOrderTraversalNode(node.getRight(),postOrderList);
        }
        postOrderList.add(node.getData());
        return postOrderList;
    }

    // O(hieght of tree)
    public static boolean search(TreeNode root, int x) {
        // Your code here
        if(root == null)
            return false;
        else
        {
            if(root.getData() == x)
            {
                return true;
            }
            else if(root.getData() < x)
            {
                return search(root.getRight(), x);
            }
            else
            {
                return search(root.getLeft(), x);
            }
        }

    }
}
