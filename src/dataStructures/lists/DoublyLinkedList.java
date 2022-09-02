package src.dataStructures.lists;

class TestDoublyLinkedList
{
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        // display empty list
        doublyLinkedList.display();
        System.out.println("MyList.size:: "+doublyLinkedList.getSize());

        // add items to list
        doublyLinkedList.addNodeAtFront("1");
        doublyLinkedList.addNodeAtFront("0");
        doublyLinkedList.addNodeAtBack("2");
        doublyLinkedList.addNodeAtBack("3");
        doublyLinkedList.addNodeAtBack("4");
        doublyLinkedList.display();
        doublyLinkedList.displayHeadAndTail();
        System.out.println("MyList.size:: " + doublyLinkedList.getSize());

        // delete items from list
        doublyLinkedList.deleteNodeAtBack();
        doublyLinkedList.deleteNodeAtFront();
        doublyLinkedList.display();

        doublyLinkedList.displayHeadAndTail();
        System.out.println("MyList.size:: " + doublyLinkedList.getSize());

        // add items at particular index
        doublyLinkedList.addNode(1, "1.1");
        doublyLinkedList.addNode(0, "0");
        doublyLinkedList.addNode(10, "10");
        doublyLinkedList.addNode(5, "4");
        doublyLinkedList.display();
        doublyLinkedList.displayHeadAndTail();
        System.out.println("MyList.size:: " + doublyLinkedList.getSize());

        // delete items at particular index
        doublyLinkedList.deleteNode(5);
        doublyLinkedList.deleteNode(0);
        doublyLinkedList.deleteNode(2);
        doublyLinkedList.display();
        doublyLinkedList.displayHeadAndTail();
        System.out.println("MyList.size:: " + doublyLinkedList.getSize());
    }
}

public class DoublyLinkedList
{
    private DoublyLinkedListNode head = null;
    // optional tail reference to add to end with O(1)
    private DoublyLinkedListNode tail = null;

    private int size = 0;

    /*
        Adds item to front
        O(1) complexity
     */
    public void addNodeAtFront(String data)
    {
        DoublyLinkedListNode node = new DoublyLinkedListNode();
        node.setData(data);
        size++;

        if(head == null)
        {
            head = tail = node;
        }
        else
        {
            head.setPrevious(node);
            node.setNext(head);
            head = node;
        }
    }

    /*
        Adds item to front
        O(1) complexity
     */
    public void addNodeAtBack(String data)
    {
        DoublyLinkedListNode node = new DoublyLinkedListNode();
        node.setData(data);
        size++;

        if(head == null)
        {
            head = tail = node;
        }
        else
        {
            tail.setNext(node);
            node.setPrevious(tail);
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
        else if(head == null || index==0)
        {
            addNodeAtFront(data);
        }
        else if(index==size)
        {
            addNodeAtBack(data);
        }
        else
        {
            int currentPosition = 0;
            DoublyLinkedListNode currentNode = head;
            while( currentPosition < index - 1 )
            {
                currentPosition++;
                currentNode = currentNode.getNext();
            }

            DoublyLinkedListNode node = new DoublyLinkedListNode();
            node.setData(data);
            node.setNext(currentNode.getNext());
            currentNode.setNext(node);
            node.setPrevious(currentNode);
            size++;
        }
    }

    /*
        Deletes item from front with O(1) complexity
     */
    public void deleteNodeAtFront()
    {
        if(head == null)
        {
            System.out.println("Out of bounds, empty list:");
        }
        else
        {
            size--;
            head = head.getNext();
            head.setPrevious(null);
        }
    }

    /*
       Deletes item from back with O(1) complexity
    */
    public void deleteNodeAtBack()
    {
        if(head == null)
        {
            System.out.println("Out of bounds, empty list:");
        }
        else
        {
            size--;
            tail=tail.getPrevious();
            tail.setNext(null);
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
        else if(index==0 || head == null)
        {
            deleteNodeAtFront();
        }
        else if(index==size-1)
        {
            deleteNodeAtBack();
        }
        else
        {
            int currentPosition = 0;
            DoublyLinkedListNode currentNode = head;
            while( currentPosition < index - 1 )
            {
                currentPosition++;
                currentNode = currentNode.getNext();
            }

            currentNode.getNext().getNext().setPrevious(currentNode);
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
            System.out.print("MyList :: null <--> ");
            DoublyLinkedListNode currentNode = head;
            while(currentNode != null)
            {
                System.out.print("{"+currentNode.getData()+"}");
                currentNode = currentNode.getNext();
                System.out.print(" <--> ");
            }
            System.out.println("null");
        }
    }

    public void display(DoublyLinkedListNode head)
    {
        if (head == null)
            System.out.println("MyList :: null");
        else
        {
            System.out.print("MyList :: null <--> ");
            DoublyLinkedListNode currentNode = head;
            while(currentNode != null)
            {
                System.out.print("{"+currentNode.getData()+"}");
                currentNode = currentNode.getNext();
                System.out.print(" <--> ");
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

    public DoublyLinkedListNode getHead()
    {
        return head;
    }

    public int getSize()
    {
        return size;
    }
}
