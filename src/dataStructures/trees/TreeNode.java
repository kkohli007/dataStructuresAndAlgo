package src.dataStructures.trees;

public class TreeNode {

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

    public void insert(int data) {
        if (data <= this.data) {
            if (left == null) {
                left = new TreeNode(data);
            } else {
                left.insert(data);
            }
        } else {
            if (right == null) {
                right = new TreeNode(data);
            } else {
                right.insert(data);
            }
        }
    }

    public void traverseInOrder() {
        if (left != null)
            left.traverseInOrder();

        System.out.print(data + " ");

        if (right != null)
            right.traverseInOrder();
    }

    public void traversePreOrder() {
        System.out.print(data + " ");

        if (left != null)
            left.traversePreOrder();

        if (right != null)
            right.traversePreOrder();
    }

    public void traversePostOrder() {
        if (left != null)
            left.traversePostOrder();

        if (right != null)
            right.traversePostOrder();

        System.out.print(data + " ");
    }

    public void breadthFirstSearch() {
        if (left == null && right == null) {
            return;
        }

        // prints current breadth
        if (left != null) {
            System.out.print(left.getData() + " ");
        }
        if (right != null) {
            System.out.print(right.getData() + " ");
        }

        // prints children
        if (left != null) {
            left.breadthFirstSearch();
        }
        if (right != null) {
            right.breadthFirstSearch();
        }
    }

    public void depthFirstSearch() {
        if (left == null && right == null) {
            return;
        }

        // prints current depth and children on left
        if (left != null) {
            System.out.print(left.getData() + " ");
            left.depthFirstSearch();
        }
        // prints current depth and children on right
        if (right != null) {
            System.out.print(right.getData() + " ");
            right.depthFirstSearch();
        }
    }

    public TreeNode get(int data) {
        if (this.data == data)
            return this;
        else if (data < this.data && left != null)
            return left.get(data);
        else if (data > this.data && right != null)
            return right.get(data);
        return null;
    }

    public TreeNode min() {
        if (left != null)
            return left.min();
        else
            return this;
    }

    public TreeNode max() {
        if (right != null)
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
