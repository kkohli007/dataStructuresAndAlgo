package src.dataStructures.queues;

import src.common.CommonUtil;

class TestQueueUsingArray
{
    public static void main(String[] args) {

        QueueUsingArray queue = new QueueUsingArray();

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

public class QueueUsingArray {

    String[] queueArray;

    int defaultSize = 10;

    int front = 0;
    int back = -1;

    public QueueUsingArray()
    {
        queueArray = new String[defaultSize];
    }

    public void add(String s)
    {
        if (back == queueArray.length - 1)
        {
            resizeQueueArray(queueArray.length*2);
        }
        queueArray[++back] = s;
    }

    public String remove()
    {
        if(front>back)
            return null;

        String temp =  queueArray[front];
        queueArray[front++] =  null;

        return temp;
    }

    public String peek()
    {
        if (front>back)
            return null;

        return queueArray[front];
    }

    private void resizeQueueArray(int i) {
        String[] newArray = new String[i];
        System.arraycopy(queueArray, 0, newArray, 0, queueArray.length);
        queueArray = newArray;
    }

    public void display()
    {

        System.out.print("MyQueue:: " + CommonUtil.printMyArray(queueArray));
        System.out.println("Front::"+front + ", Back::" + back);
    }
}
