package src.dataStructures.lists;

class TestSinglyLinkedList
{
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        // display empty list
        singlyLinkedList.display();
        System.out.println("MyList.size:: "+singlyLinkedList.getSize());

        // add items to list
        singlyLinkedList.addNode("1");
        singlyLinkedList.addNode("2");
        singlyLinkedList.addNode("3");
        singlyLinkedList.display();
        singlyLinkedList.displayHeadAndTail();
        System.out.println("MyList.size:: " + singlyLinkedList.getSize());

        System.out.println("MyList.head:: " + singlyLinkedList.getHead());

        // delete items from list
        singlyLinkedList.deleteNode();
        singlyLinkedList.display();
        System.out.println("MyList.size:: "+singlyLinkedList.getSize());

        singlyLinkedList.addNode("4");
        System.out.println("MyList.head:: " + singlyLinkedList.getHead());

        // add items at particular index
        singlyLinkedList.addNode(2, "3.1");
        singlyLinkedList.addNode(0, "1");
        singlyLinkedList.addNode(10, "10");
        singlyLinkedList.addNode(5, "5");
        singlyLinkedList.display();

        // delete items at particular index
        singlyLinkedList.deleteNode(3);
        singlyLinkedList.deleteNode(0);
        singlyLinkedList.deleteNode(4);
        singlyLinkedList.display();

        System.out.println("MyList.head:: " + singlyLinkedList.getHead());
    }
}

public class SinglyLinkedList
{
    private class Node
    {
        private String data;

        private Node next;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data='" + data + '\'' +
                    ", next=" + next +
                    '}';
        }
    }

    private Node head = null;
    // optional tail reference to add to end with O(1)
    private Node tail = null;

    private int size = 0;

    /*
        Adds item to end
        Can also do add item to front with just storing head node reference
        both approaches with O(1) complexity
     */
    public void addNode(String data)
    {
        Node node = new Node();
        node.setData(data);
        node.setNext(null);
        size++;

        if(head == null)
        {
            head = tail = node;
        }
        else if (head.getNext() == null)
        {
            head.setNext(node);
            tail = node;
        }
        else
        {
            tail.setNext(node);
            tail = node;
        }
    }

    /*
    add item at particular index or before/after particular element would have O(n) complexity
     */
    public void addNode(int index, String data)
    {
        if(index>size)
        {
            System.out.println("Out of bounds, can't add at index:" + index);
        }
        //adding at the end
        else if(index==size || head == null || head.getNext() == null)
        {
            addNode(data);
        }
        else if(index==0)
        {
            Node node = new Node();
            node.setData(data);
            node.setNext(head);
            head = node;
            size++;
        }
        else
        {
            // 0 ,1, 2, 3 .. index == 2,, size=4
            int currentPosition = 0;
            Node currentNode = head;
            while( currentPosition < index - 1 )
            {
                currentPosition++;
                currentNode = currentNode.getNext();
            }

            Node node = new Node();
            node.setData(data);
            node.setNext(currentNode.getNext());
            currentNode.setNext(node);
            size++;
        }
    }


    /*
        Deletes item from front with O(1) complexity
     */
    public void deleteNode()
    {
        if(head == null)
        {
            System.out.println("Out of bounds, empty list:");
        }
        else if (head.getNext() == null)
        {
            size--;
            head = null;
        }
        else
        {
            size--;
            head = head.getNext();
        }
    }

    /*
    Delete from end node or at particular index would require traversal to know previous node from tail so O(n)
     */
    public void deleteNode(int index)
    {
        if(index>size-1)
        {
            System.out.println("Out of bounds, can't remove from index:" + index);
        }
        //removing at the front
        else if(index==0 || head == null || head.getNext() == null)
        {
            deleteNode();
        }
        else
        {
            // 0 ,1, 2, 3 .. index == 2,, size=4
            int currentPosition = 0;
            Node currentNode = head;
            while( currentPosition < index - 1 )
            {
                currentPosition++;
                currentNode = currentNode.getNext();
            }

            currentNode.setNext(currentNode.getNext().getNext());
            size--;
        }
    }

    public void display()
    {
        if (head == null)
            System.out.println("MyList :: null");
        else
        {
            System.out.print("MyList :: ");
            Node currentNode = head;
            while(currentNode != null)
            {
                System.out.print("{"+currentNode.getData()+"}");
                currentNode = currentNode.getNext();
                System.out.print(" --> ");
            }
            System.out.println("null");
        }
    }

    public void displayHeadAndTail()
    {
        if (head == null)
            System.out.println("Head :: null, Tail :: null");
        else
        {
            System.out.println("Head :: {" + head.getData() + "}, Tail :: {" + tail.getData() + "}");
        }
    }

    public Node getHead()
    {
        return head;
    }

    public int getSize()
    {
        return size;
    }
}
