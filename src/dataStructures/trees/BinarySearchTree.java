package src.dataStructures.trees;

import src.dataStructures.queues.QueueUsingArray;

import java.util.*;

public class BinarySearchTree {

    private TreeNode root;

    public BinarySearchTree(int data) {
        root = new TreeNode(data);
    }

    public void insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
        } else {
            root.insert(data);
        }
    }

    @Deprecated
    public void insertWithoutRecursion(int data) {
        TreeNode currentNode = root;
        TreeNode nextNode = root;

        while (nextNode != null) {
            currentNode = nextNode;
            if (data <= nextNode.getData()) {
                nextNode = nextNode.getLeft();
            } else {
                nextNode = nextNode.getRight();
            }
        }
        if (data <= currentNode.getData()) {
            currentNode.setLeft(new TreeNode(data));
        } else {
            currentNode.setRight(new TreeNode(data));
        }
    }

    public void delete(int data) {
        root = deleteRecursive(data, root);
    }

    public TreeNode deleteRecursive(int data, TreeNode node) {
        if (node == null) {
            System.out.println("No element found in BST");
            return null;
        }
        if (data < node.getData()) {
            node.setLeft(deleteRecursive(data, node.getLeft()));
        } else if (data > node.getData()) {
            node.setRight(deleteRecursive(data, node.getRight()));
        } else if (node.getData() == data) {
            //1. root is leaf
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }
            //2. root has two child
            else if (node.getLeft() != null && node.getRight() != null) {
                //find the largest element on left subtree and replace at this position of current node
                int maxOnLeftSubtree = node.getLeft().max().getData();
                node.setData(maxOnLeftSubtree);
                deleteRecursive(maxOnLeftSubtree, node.getLeft());

                /* or another approach to find the smallest element on right subtree
                 and replace at this position of current node.
                     int minOnRightSubtree = node.getRight().min().getData();
                     node.setData(minOnRightSubtree);
                     deleteRecursive(minOnRightSubtree, node.getRight());
                 */
                return node;
            }
            //3. root has one child
            else if (node.getLeft() != null) {
                return node.getLeft();
            } else {
                return node.getRight();
            }
        }
        return node;
    }

    public void traverseInOrder() {
        if (root == null) {
            System.out.println("No element found in BST");
            return;
        }
        if (root.getLeft() != null)
            root.getLeft().traverseInOrder();

        System.out.print(root.getData() + " ");

        if (root.getRight() != null)
            root.getRight().traverseInOrder();

        System.out.println("");
    }

    public void traversePreOrder() {
        if (root == null) {
            System.out.println("No element found in BST");
            return;
        }
        System.out.print(root.getData() + " ");

        if (root.getLeft() != null)
            root.getLeft().traversePreOrder();

        if (root.getRight() != null)
            root.getRight().traversePreOrder();

        System.out.println("");
    }

    public void traversePostOrder() {
        if (root == null) {
            System.out.println("No element found in BST");
            return;
        }
        if (root.getLeft() != null)
            root.getLeft().traversePostOrder();

        if (root.getRight() != null)
            root.getRight().traversePostOrder();

        System.out.print(root.getData() + " ");

        System.out.println("");
    }

    public void breadthFirstSearch()
    {
        if(root == null)
        {
            System.out.println("No element found in BST");
            return;
        }
        System.out.print("BFS TRAVERSAL: [");

        breadthFirstSearch(new ArrayList<>(Arrays.asList(root)));

        System.out.println("]");
    }

    private void breadthFirstSearch(List<TreeNode> currentDepthNodes)
    {
        Iterator<TreeNode> nodeIterator = currentDepthNodes.listIterator();

        List<TreeNode> childDepthNodes = new ArrayList<>();

        while (nodeIterator.hasNext())
        {
            TreeNode node = nodeIterator.next();
            System.out.print(node.getData() + " ");

            if(node.getLeft() != null)
            {
                childDepthNodes.add(node.getLeft());
            }
            if(node.getRight() != null)
            {
                childDepthNodes.add(node.getRight());
            }
        }

        if(childDepthNodes.size() > 0)
        {
            breadthFirstSearch(childDepthNodes);
        }
    }

    public void breadthFirstSearchIterative()
    {
        if(root == null)
        {
            System.out.println("No element found in BST");
            return;
        }
        System.out.print("BFS TRAVERSAL: [");

        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(root);

        while(nodeQueue.size()>0)
        {
            TreeNode currentNode = nodeQueue.remove();
            System.out.print(currentNode.getData() + " ");

            if(currentNode.getLeft()!=null)
            {
                nodeQueue.add(currentNode.getLeft());
            }
            if(currentNode.getRight()!=null)
            {
                nodeQueue.add(currentNode.getRight());
            }
        }

        System.out.println("]");
    }

    public void depthFirstSearch()
    {
        if(root == null)
        {
            System.out.println("No element found in BST");
            return;
        }
        System.out.print("DFS TRAVERSAL: [");
        System.out.print(root.getData() + " ");

        // prints current breadth
        if(root.getLeft() != null)
        {
            System.out.print(root.getLeft().getData() + " ");
            root.getLeft().depthFirstSearch();
        }
        if(root.getRight() != null)
        {
            System.out.print(root.getRight().getData() + " ");
            root.getRight().depthFirstSearch();
        }
        System.out.println("]");
    }

    public TreeNode get(int data) {
        if (root == null) {
            System.out.println("No element found in BST");
            return null;
        } else {
            return root.get(data);
        }
    }

    public Integer min() {
        if (root == null) {
            System.out.println("No element found in BST");
            return null;
        } else {
            return root.min().getData();
        }
    }

    public Integer max() {
        if (root == null) {
            System.out.println("No element found in BST");
            return null;
        } else {
            return root.max().getData();
        }
    }

    public void display() {
        System.out.println(root.toString());
    }

    public TreeNode getRoot()
    {
        return root;
    }
}

