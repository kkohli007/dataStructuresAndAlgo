package src.dataStructures.queues;

import src.dataStructures.lists.SinglyLinkedList;

class TestQueueUsingList {

    public static void main(String[] args) {

        QueueUsingList queue = new QueueUsingList();

        queue.add("X");
        queue.display();
        queue.remove();
        queue.display();
        System.out.println("Peek:" + queue.peek());

        queue.add("K");
        queue.add("U");
        queue.add("N");
        queue.add("A");
        queue.add("L");

        queue.display();
        System.out.println("Peek:" + queue.peek());

        queue.remove();
        queue.display();

        queue.add("K");
        queue.add("O");
        queue.add("H");
        queue.add("L");
        queue.display();

        queue.add("I");
        queue.display();

        queue.remove();
        queue.display();
        System.out.println("Peek:" + queue.peek());
    }
}

public class QueueUsingList {

    SinglyLinkedList singlyLinkedList;

    public QueueUsingList() {
        singlyLinkedList = new SinglyLinkedList();
    }

    public void add(String data) {
        singlyLinkedList.addNodeAtEnd(data);
    }

    public String remove() {
        return singlyLinkedList.deleteNode();
    }

    public String peek() {
        return singlyLinkedList.getHeadData();
    }

    public void display() {
        singlyLinkedList.display();
    }

}
