package src.dataStructures.lists;

public class SinglyLinkedListNode
{
    private String data;

    private SinglyLinkedListNode next;

    public SinglyLinkedListNode(){

    }

    public SinglyLinkedListNode(String data)
    {
        this.data = data;
        this.next = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public SinglyLinkedListNode getNext() {
        return next;
    }

    public void setNext(SinglyLinkedListNode next) {
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