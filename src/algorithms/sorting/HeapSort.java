package src.algorithms.sorting;

import src.common.CommonUtil;
import src.dataStructures.heaps.Heap;

public class HeapSort {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap = heapSort(heap);
    }

    private static Heap heapSort(Heap heap)
    {
        Integer[] heapArray = heap.getHeapArray();
        System.out.println("Heap: " + CommonUtil.printMyArray(heapArray));

        int index = heap.getSize() - 1;

        while(index >= 0)
        {
            int root = heapArray[0];
            heapArray[0] = heapArray[index];
            heapArray[index] = root;
            System.out.println("Index Fixed: " + index);
            index--;
            heap.heapifyArrayBelow(0, index);

            System.out.println("Heap:" + CommonUtil.printMyArray(heapArray));

        }

        return heap;
    }
}
