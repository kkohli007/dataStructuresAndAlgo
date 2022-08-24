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
}
