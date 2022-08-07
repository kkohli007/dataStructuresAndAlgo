package src.dataStructures.trees;

public class BreadthFirstSearch {

    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree(9);
        binarySearchTree.insert(4);
        binarySearchTree.insert(20);
        binarySearchTree.insert(1);
        binarySearchTree.insert(6);
        binarySearchTree.insert(15);
        binarySearchTree.insert(170);
        binarySearchTree.insert(-2);
        binarySearchTree.insert(2);
        binarySearchTree.insert(8);
        binarySearchTree.insert(13);
        binarySearchTree.insert(155);
        binarySearchTree.insert(200);
        /*
                                    9
                    4                               20
            1               6               15              170
        -2      2               8       13              155     200
        */
        binarySearchTree.breadthFirstSearch();
        binarySearchTree.breadthFirstSearchIterative();
        binarySearchTree.depthFirstSearch();


    }
}
