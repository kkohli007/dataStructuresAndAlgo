package src.dataStructures.stack;

import src.common.CommonUtil;

class TestStackUsingArray {

    public static void main(String[] args) {

        StackUsingArray stack = new StackUsingArray(10);

        stack.push("0");
        System.out.println("CurrentIndex:" + stack.top);
        stack.display();


        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        stack.push("7");
        stack.push("8");
        stack.push("9");
        System.out.println("CurrentIndex:" + stack.top);
        stack.display();

        stack.push("10");
        stack.push("11");
        stack.push("12");
        stack.push("13");
        stack.push("14");
        stack.push("15");
        stack.push("16");
        stack.push("17");
        stack.push("18");
        stack.push("19");
        stack.push("20");

        System.out.println("CurrentIndex:" + stack.top);
        stack.display();


        System.out.println(stack.pop());
        System.out.println("CurrentIndex:" + stack.top);
        stack.display();

        System.out.println(stack.pop());
        System.out.println("CurrentIndex:" + stack.top);
        stack.display();

        stack.push("19");
        stack.push("20");

        System.out.println("CurrentIndex:" + stack.top);
        stack.display();

        System.out.println("Peek:" + stack.peek());
        stack.display();

    }
}

public class StackUsingArray
{
    String[] stack;
    int top;

    StackUsingArray(int size)
    {
        this.stack = new String[size];
        this.top = size - 1;
    }

    public void push(String data)
    {
        if(top <0)
        {
            // can use System.ArrayCopy();
            // O(n) because of resizing
            resizeIncreaseStack();
        }
        stack[top] = data;
        top--;
    }

    public void resizeIncreaseStack()
    {
        String[] tempStack = new String[stack.length*2];

        int currentStackCounter = 0;
        for(int i=stack.length; i<stack.length*2; i++)
        {
            tempStack[i] = stack[currentStackCounter];
            currentStackCounter++;
        }
        top = stack.length-1;
        stack = tempStack;
    }

    public String pop()
    {
        if(top +1 >= stack.length)
        {
            return null;
        }

        String temp = stack[top +1];
        stack[top +1] = null;
        top++;

        // resizing not mandatory if memory not issue. without resize we will then have O(1), else O(n)
        if(top >= stack.length/2-1)
        {
            // can use System.ArrayCopy();
            resizeDecreaseStack();
        }
        return temp;
    }

    public void resizeDecreaseStack()
    {
        String[] tempStack = new String[stack.length/2];

        int currentStackCounter = 0;
        for(int i = top +1; i<stack.length; i++)
        {
            tempStack[currentStackCounter] = stack[i];
            currentStackCounter++;
        }
        top = -1;
        stack = tempStack;
    }

    //O(1)
    public String peek()
    {
        if(top +1 >= stack.length)
        {
            //can throw exception
            return null;
        }

        return stack[top +1];
    }

    public void display()
    {
        System.out.println("MyStack:: " + CommonUtil.printMyArray(stack));
    }

    public int getSize()
    {
        return stack.length;
    }
}

