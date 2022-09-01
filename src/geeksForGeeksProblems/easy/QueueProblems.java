package src.geeksForGeeksProblems.easy;

import src.common.CommonUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueProblems {

    public static void main(String[] args) {

        Queue<Integer> myqueue = new LinkedList<>();
        myqueue.add(4);
        myqueue.add(3);
        myqueue.add(2);
        myqueue.add(1);

        System.out.println("Queue:" + CommonUtil.printMyQueue(myqueue));

        myqueue = rev(myqueue);
        System.out.println("Queue Reversed:" + CommonUtil.printMyQueue(myqueue));
    }

    public static Queue<Integer> rev(Queue<Integer> myq){
        //add code here.
        Stack<Integer> stck = new Stack<>();

        while(!myq.isEmpty()){
            stck.add(myq.poll());
        }

        while(!stck.isEmpty())
            myq.add(stck.pop());

        return myq;
    }

}
