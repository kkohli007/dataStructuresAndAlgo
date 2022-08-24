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

    static void printList(SinglyLinkedListNode head){

        SinglyLinkedListNode currentNode = head;
        System.out.println(currentNode.getData() + " ");

        while(currentNode.getNext() != null){
            currentNode = currentNode.getNext();
            System.out.println(currentNode.getData() + " ");
        }
    }
}