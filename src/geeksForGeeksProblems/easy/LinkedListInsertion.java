package src.geeksForGeeksProblems.easy;

public class LinkedListInsertion {

    LinkedListNode head;

    public static void main(String[] args) {

        LinkedListInsertion myList = new LinkedListInsertion();
        myList.head = myList.insertAtBeginning(myList.head, 9);
        myList.head = myList.insertAtEnd(myList.head, 5);
        myList.head = myList.insertAtEnd(myList.head, 6);
        myList.head = myList.insertAtBeginning(myList.head, 2);
        myList.head = myList.insertAtBeginning(myList.head, 5);

        myList.printList(myList.head);
    }

    //Function to insert a node at the beginning of the linked list.
    LinkedListNode insertAtBeginning(LinkedListNode head, int x)
    {
        LinkedListNode newNode = new LinkedListNode(x);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        return head;
    }

    //Function to insert a node at the end of the linked list.
    LinkedListNode insertAtEnd(LinkedListNode head, int x)
    {
        LinkedListNode newNode = new LinkedListNode(x);
        if (head == null)
        {
            head = newNode;
        }
        else
        {
            LinkedListNode currentNode = head;
            while(currentNode.next!=null)
            {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        return head;
    }

    void printList(LinkedListNode head){


        LinkedListNode currentNode = head;
        System.out.println(currentNode.data + " ");

        while(currentNode.next != null){
            currentNode = currentNode.next;
            System.out.println(currentNode.data + " ");
        }
    }
}


class LinkedListNode {
    int data;
    LinkedListNode next;

    LinkedListNode(int x){
        data = x;
        next = null;
    }
}
