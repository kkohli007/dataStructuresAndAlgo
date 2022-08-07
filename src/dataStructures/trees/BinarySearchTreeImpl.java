package src.dataStructures.trees;

public class BinarySearchTreeImpl {

    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree(18);
        binarySearchTree.insert(15);
        binarySearchTree.insert(20);
        binarySearchTree.insert(22);
        binarySearchTree.insert(21);
        binarySearchTree.insert(19);
        binarySearchTree.insert(34);
        binarySearchTree.insert(30);
        binarySearchTree.insert(10);
        binarySearchTree.insert(16);
        binarySearchTree.insert(9);
        binarySearchTree.insert(11);
        binarySearchTree.insert(12);
        binarySearchTree.insert(17);

        binarySearchTree.display();

        System.out.print("In Order:");
        binarySearchTree.traverseInOrder();
        System.out.print("Pre Order:");
        binarySearchTree.traversePreOrder();
        System.out.print("Post Order:");
        binarySearchTree.traversePostOrder();

        System.out.println("Fetched node:" + binarySearchTree.get(20));
        System.out.println("Fetched node:" + binarySearchTree.get(2));

        System.out.println("Min:" + binarySearchTree.min());
        System.out.println("Max:" + binarySearchTree.max());

        binarySearchTree.delete(17);
        binarySearchTree.delete(11);
        binarySearchTree.display();
        binarySearchTree.delete(31); //node not found
        binarySearchTree.display();

        binarySearchTree.delete(18);
        binarySearchTree.display();
        binarySearchTree.traverseInOrder();
    }
}