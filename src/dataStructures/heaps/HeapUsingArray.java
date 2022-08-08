package src.dataStructures.heaps;

import src.common.CommonUtil;

public class HeapUsingArray {

    public static void main(String[] args) {
        Heap heap = new Heap();
        /*
        				22
                19				18
            15		3		14		4
        12
         */
        heap.insert(22);
        heap.insert(19);
        heap.insert(18);
        heap.insert(15);
        heap.insert(3);
        heap.insert(14);
        heap.insert(4);
        heap.insert(12);

        System.out.println("Heap: " + CommonUtil.printMyArray(heap.heapArray));

        // insert a big number which needs heapify, new heap should look like this
        /*
        				22
                20				18
            19		3		14		4
        12      15
         */
        heap.insert(20);
        System.out.println("Heap: " + CommonUtil.printMyArray(heap.heapArray));

        Heap heap2 = new Heap();
        heap2.insert(80);
        heap2.insert(75);
        heap2.insert(60);
        heap2.insert(68);
        heap2.insert(55);
        heap2.insert(40);
        heap2.insert(52);
        heap2.insert(67);
        /*
        				80
                75				60
            68		55		40		52
        67
         */
        System.out.println("Heap2 Original: " + CommonUtil.printMyArray(heap2.heapArray));

        // delete a number so that below heap needs to be fixed
        heap2.delete(1);
        /*
        				80
                68				60
            67		55		40		52
         */
        System.out.println("Heap2 Deleted 75: " + CommonUtil.printMyArray(heap2.heapArray));

        heap2.insert(75);
        /*
        				80
                75				60
            68		55		40		52
        67
         */
        System.out.println("Heap2 Reinserted 75: " + CommonUtil.printMyArray(heap2.heapArray));

        // delete a number so that above heap needs to be fixed
        heap2.delete(5);
        /*
        				80
                75				67
            68		55		60		52
         */
        System.out.println("Heap2 Deleted 40: " + CommonUtil.printMyArray(heap2.heapArray));

        System.out.println("Peek : "+ heap2.peek());
        heap2.delete(0);
        System.out.println("Heap2 Deleted 80: " + CommonUtil.printMyArray(heap2.heapArray));
        System.out.println("Peek : "+ heap2.peek());
    }
}

