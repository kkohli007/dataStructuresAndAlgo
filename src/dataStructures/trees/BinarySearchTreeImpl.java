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

class BinarySearchTree {

    private TreeNode root;

    public BinarySearchTree(int data)
    {
        root = new TreeNode(data);
    }

    public void insert(int data)
    {
        if(root == null)
        {
            root = new TreeNode(data);
        }
        else
        {
            root.insert(data);
        }
    }

    @Deprecated
    public void insertWithoutRecursion(int data)
    {
        TreeNode currentNode = root;
        TreeNode nextNode = root;

        while(nextNode!=null)
        {
            currentNode = nextNode;
            if(data <= nextNode.getData())
            {
                nextNode = nextNode.getLeft();
            }
            else
            {
                nextNode = nextNode.getRight();
            }
        }
        if(data <= currentNode.getData())
        {
            currentNode.setLeft(new TreeNode(data));
        }
        else
        {
            currentNode.setRight(new TreeNode(data));
        }
    }

    public void delete(int data)
    {
        root = deleteRecursive(data, root);
    }

    public TreeNode deleteRecursive(int data, TreeNode node)
    {
        if(node == null)
        {
            System.out.println("No element found in BST");
            return null;
        }
        if(data < node.getData())
        {
            node.setLeft(deleteRecursive(data, node.getLeft()));
        }
        else if(data > node.getData())
        {
            node.setRight(deleteRecursive(data, node.getRight()));
        }
        else if(node.getData() == data)
        {
            //1. root is leaf
            if(node.getLeft() == null && node.getRight() == null)
            {
                return null;
            }
            //2. root has two child
            else if(node.getLeft()!=null && node.getRight()!=null)
            {
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
            else if(node.getLeft()!=null)
            {
                return node.getLeft();
            }
            else
            {
                return node.getRight();
            }
        }
        return node;
    }

    public void traverseInOrder()
    {
        if(root == null)
        {
            System.out.println("No element found in BST");
            return;
        }
        if(root.getLeft()!=null)
            root.getLeft().traverseInOrder();

        System.out.print(root.getData() + " ");

        if(root.getRight()!=null)
            root.getRight().traverseInOrder();

        System.out.println("");
    }

    public void traversePreOrder()
    {
        if(root == null)
        {
            System.out.println("No element found in BST");
            return;
        }
        System.out.print(root.getData() + " ");

        if(root.getLeft()!=null)
            root.getLeft().traversePreOrder();

        if(root.getRight()!=null)
            root.getRight().traversePreOrder();

        System.out.println("");
    }

    public void traversePostOrder()
    {
        if(root == null)
        {
            System.out.println("No element found in BST");
            return;
        }
        if(root.getLeft()!=null)
            root.getLeft().traversePostOrder();

        if(root.getRight()!=null)
            root.getRight().traversePostOrder();

        System.out.print(root.getData() + " ");

        System.out.println("");
    }

    public TreeNode get(int data)
    {
        if(root == null)
        {
            System.out.println("No element found in BST");
            return null;
        }
        else
        {
            return root.get(data);
        }
    }

    public Integer min()
    {
        if(root == null)
        {
            System.out.println("No element found in BST");
            return null;
        }
        else
        {
            return root.min().getData();
        }
    }

    public Integer max()
    {
        if(root == null)
        {
            System.out.println("No element found in BST");
            return null;
        }
        else
        {
            return root.max().getData();
        }
    }

    public void display()
    {
        System.out.println(root.toString());
    }
}


class TreeNode {

    private int data;

    private TreeNode left;

    private TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void insert(int data)
    {
        if(data <= this.data)
        {
            if(left == null)
            {
                left = new TreeNode(data);
            }
            else
            {
                left.insert(data);
            }
        }
        else
        {
            if(right == null)
            {
                right = new TreeNode(data);
            }
            else {
                right.insert(data);
            }
        }
    }

    public void traverseInOrder()
    {
        if(left!=null)
            left.traverseInOrder();

        System.out.print(data + " ");

        if(right!=null)
            right.traverseInOrder();
    }

    public void traversePreOrder()
    {
        System.out.print(data + " ");

        if(left!=null)
            left.traversePreOrder();

        if(right!=null)
            right.traversePreOrder();
    }

    public void traversePostOrder()
    {
        if(left!=null)
            left.traversePostOrder();

        if(right!=null)
            right.traversePostOrder();

        System.out.print(data + " ");
    }

    public TreeNode get(int data)
    {
        if(this.data == data)
            return this;
        else if(data < this.data && left!=null)
            return left.get(data);
        else if(data > this.data && right!=null)
            return right.get(data);
        return null;
    }

    public TreeNode min()
    {
        if(left != null)
            return left.min();
        else
            return this;
    }

    public TreeNode max()
    {
        if(right !=null)
            return right.max();
        else
            return this;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
