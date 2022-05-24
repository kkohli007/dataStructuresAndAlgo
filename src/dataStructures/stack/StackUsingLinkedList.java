package src.dataStructures.stack;

import src.dataStructures.lists.SinglyLinkedList;

class TestStackUsingLinkedList {

    public static void main(String[] args) {

        StackUsingLinkedList stack = new StackUsingLinkedList();

        System.out.println(stack.peek());
        stack.push("1");
        System.out.println(stack.peek());
        System.out.println(stack.pop());

        stack.push("2");
        stack.push("3");
        stack.push("4");

        stack.display();

        System.out.println(stack.pop());
        stack.display();
    }
}

public class StackUsingLinkedList
{
    SinglyLinkedList stack;

    public StackUsingLinkedList()
    {
        stack = new SinglyLinkedList();
    }

    public void push(String data)
    {
        stack.addNode(data);
    }

    public String pop()
    {
        if(stack.getSize() == 0)
            return null;
        return stack.deleteNode();
    }

    public String peek()
    {
        if(stack.getSize() == 0)
            return null;
        return stack.getHeadData();
    }

    public void display()
    {
        stack.display();
    }
}

