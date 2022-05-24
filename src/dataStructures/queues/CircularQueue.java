package src.dataStructures.queues;

import src.common.CommonUtil;

class TestCircularQueueUsingArray
{
    public static void main(String[] args) {

        CircularQueue queue = new CircularQueue();

        //Test with default size :2
        queue.add("0");
        queue.add("1");
        queue.display();
        queue.remove();
        queue.display();
        queue.add("2");
        queue.display();
        queue.remove();
        queue.add("3");
        queue.display();
        queue.remove();
        queue.remove();
        queue.display();
        queue.add("4");
        queue.add("5");
        queue.display();
        queue.add("6");
        queue.display();

        /*Test with default size :5
        queue.add("0");
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        queue.remove();
        queue.add("5");
        queue.display();
        queue.remove();
        queue.add("6");
        queue.display();
        queue.add("7");
        queue.display();*/
    }
}

public class CircularQueue {

    String[] queueArray;

    int defaultSize = 5;

    int front;
    int back;
    int noOfElements =0;

    public CircularQueue()
    {
        queueArray = new String[defaultSize];
    }

    public void add(String s)
    {
        if(noOfElements == queueArray.length)
        {
            resizeQueueArray(queueArray.length*2);
        }
        if (back==queueArray.length)
        {
            back=0;
        }
        queueArray[back++] = s;
        noOfElements++;
    }

    public String remove()
    {
        String temp =  queueArray[front];
        queueArray[front] =  null;

        if (front==queueArray.length-1)
        {
            front=0;
        }
        else
        {
            front++;
        }

        noOfElements--;
        return temp;
    }

    public String peek()
    {
        if (noOfElements==0)
            return null;

        return queueArray[front];
    }

    private void resizeQueueArray(int newSize) {
        String[] newArray = new String[newSize];
        int x = front;
        for (int i=0; i<noOfElements; i++)
        {
            newArray[i] = queueArray[x];
            if(x==queueArray.length-1)
                x=0;
            else
                x++;
        }
        front=0;
        back=noOfElements;
        queueArray = newArray;
    }

    public int size()
    {
        if(front<=back)
            return back-front;
        else
            return back-front+queueArray.length;
    }

    public void display()
    {
        System.out.print("MyQueue:: " + CommonUtil.printMyArray(queueArray));
        System.out.println("Front::"+front + ", Back::" + back);
    }
}
