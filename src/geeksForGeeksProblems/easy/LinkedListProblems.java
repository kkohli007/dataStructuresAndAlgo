package src.geeksForGeeksProblems.easy;

import src.dataStructures.lists.SinglyLinkedList;
import src.dataStructures.lists.SinglyLinkedListNode;

public class LinkedListProblems {

    public static void main(String[] args) {

        // Test is circular
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addNode("5");
        singlyLinkedList.addNode("4");
        singlyLinkedList.addNode("3");
        singlyLinkedList.addNode("2");
        singlyLinkedList.addNode("1");
        src.dataStructures.lists.SinglyLinkedListNode curr = singlyLinkedList.getHead();
        while(curr.getNext() !=null)
        {
            curr = curr.getNext();
            if(curr.getData()=="5") {
                curr.setNext(singlyLinkedList.getHead());
                break;
            }
        }
        System.out.println(isCircular(singlyLinkedList.getHead()));

        // Test insert at beginning and end
        SinglyLinkedList singlyLinkedListNew = new SinglyLinkedList();
        singlyLinkedListNew.setHead(insertAtBeginning(singlyLinkedListNew.getHead(), 9));
        singlyLinkedListNew.setHead(insertAtEnd(singlyLinkedListNew.getHead(), 5));
        singlyLinkedListNew.setHead(insertAtEnd(singlyLinkedListNew.getHead(), 6));
        singlyLinkedListNew.setHead(insertAtBeginning(singlyLinkedListNew.getHead(), 2));
        singlyLinkedListNew.setHead(insertAtBeginning(singlyLinkedListNew.getHead(), 5));

        printList(singlyLinkedListNew.getHead());

        // Test insert at middle
        insertInMid(singlyLinkedListNew.getHead(), 4);
        printList(singlyLinkedListNew.getHead());

        //isLengthEvenorOdd
        System.out.println("isLengthEvenorOdd:" + isLengthEvenorOdd(singlyLinkedListNew.getHead()));
        System.out.println("isLengthEvenorOdd:" + isLengthEvenorOddOptimized(singlyLinkedListNew.getHead()));
    }

    static boolean isCircular(SinglyLinkedListNode head)
    {
        SinglyLinkedListNode curr = head;
        while(curr.getNext()!=null)
        {
            curr = curr.getNext();
            if(curr.getData() == head.getData())
            {
                return true;
            }
        }
        return false;
    }

    //Function to insert a node at the beginning of the linked list.
    static SinglyLinkedListNode insertAtBeginning(SinglyLinkedListNode head, int x)
    {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(x+"");
        if (head != null) {
            newNode.setNext(head);
        }
        head = newNode;
        return head;
    }

    //Function to insert a node at the end of the linked list.
    static SinglyLinkedListNode insertAtEnd(SinglyLinkedListNode head, int x)
    {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(x+"");
        if (head == null)
        {
            head = newNode;
        }
        else
        {
            SinglyLinkedListNode currentNode = head;
            while(currentNode.getNext()!=null)
            {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
        return head;
    }

    //Function to insert a node at the middle of the linked list.
    public static SinglyLinkedListNode insertInMid(SinglyLinkedListNode head, int data){
        //Insert code here, return the head of modified linked list

        if(head == null)
            return null;

        // 1,2,3,4,5,6
        SinglyLinkedListNode fastNode = head;
        SinglyLinkedListNode slowNode = head;
        while(fastNode.getNext() !=null && fastNode.getNext().getNext()!=null)
        {
            fastNode = fastNode.getNext().getNext();
            slowNode = slowNode.getNext();
        }

        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data+"");

        if(slowNode.getNext()!=null)
        {
            newNode.setNext(slowNode.getNext());
        }
        slowNode.setNext(newNode);
        return head;
    }

    static void printList(SinglyLinkedListNode head){

        SinglyLinkedListNode currentNode = head;
        System.out.print(currentNode.getData() + "->");

        while(currentNode.getNext() != null){
            currentNode = currentNode.getNext();
            System.out.print(currentNode.getData() + "->");
        }

        System.out.println("null");
    }

    static int isLengthEvenorOdd(SinglyLinkedListNode head1)
    {
        //Add your code here.
        if(head1==null)
            return 0;

        SinglyLinkedListNode slowNode = head1;
        SinglyLinkedListNode fastNode = head1;

        boolean isEven = false;

        while(slowNode.getNext()!=null)
        {
            slowNode = slowNode.getNext();

            if(fastNode.getNext() == null)
            {
                break;
            }
            else if(fastNode.getNext().getNext() == null)
            {
                isEven=true;
                break;
            }
            else
            {
                fastNode = fastNode.getNext().getNext();
            }
        }

        if(isEven)
            return 0;
        else
            return 1;
    }


    static int isLengthEvenorOddOptimized(SinglyLinkedListNode head1)
    {
        //Add your code here.
        while(head1!=null && head1.getNext()!=null)
        {
            head1 = head1.getNext().getNext();
        }

        if(head1==null)
            return 0;
        return 1;
    }
}
