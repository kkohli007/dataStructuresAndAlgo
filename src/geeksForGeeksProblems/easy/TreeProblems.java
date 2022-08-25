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

        // Find minimum node
        BinarySearchTree bst2 = new BinarySearchTree(1);
        bst2.insert(5);
        bst2.insert(4);
        bst2.insert(6);
        bst2.insert(3);
        bst2.insert(7);
        bst2.display();

        System.out.println("Mininum value in tree: " + minValue(bst2.getRoot()));


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
}
