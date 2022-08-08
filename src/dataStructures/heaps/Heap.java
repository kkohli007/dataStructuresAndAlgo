package src.dataStructures.heaps;

public class Heap {

    Integer[] heapArray;

    int size;

    public Heap() {
        heapArray = new Integer[10];
    }

    public void insert(int data) {
        if (isFull()) {
            System.out.println("Heap is full");
            return;
        }

        heapArray[size++] = data;

        heapifyArrayAbove(size - 1);
    }

    public int delete(int index) {
        if (isEmpty()) {
            System.out.println("Heap is empty");
            return -1;
        }

        if (index >= size) {
            System.out.println("No element at this index");
            return -1;
        }

        int deletedValue = heapArray[index];
        heapArray[index] = heapArray[size - 1];
        heapArray[--size] = null;

        int parentIndex = getParent(index);
        if (heapArray[parentIndex] < heapArray[index]) {
            heapifyArrayAbove(index);
        } else {
            heapifyArrayBelow(index, size - 1);
        }

        return deletedValue;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Heap is empty");
            return -1;
        }
        return heapArray[0];
    }

    public void heapifyArrayAbove(int index) {
        int newValue = heapArray[index];

        while (index > 0) {
            int parentIndex = getParent(index);
            if (heapArray[parentIndex] < newValue) {
                heapArray[index] = heapArray[parentIndex];
                heapArray[parentIndex] = newValue;
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    public void heapifyArrayBelow(int startIndex, int lastIndex) {
        int newValue = heapArray[startIndex];

        int childToSwap;

        while (startIndex < lastIndex) {
            int leftChild = getChild(startIndex, true);
            int rightChild = getChild(startIndex, false);

            if (leftChild <= lastIndex && heapArray[leftChild] != null) {
                if(rightChild > lastIndex)
                {
                    childToSwap = leftChild;
                }
                else{
                    childToSwap = heapArray[leftChild] > heapArray[rightChild] ? leftChild : rightChild;
                }

                if(heapArray[childToSwap] > newValue)
                {
                    heapArray[startIndex] = heapArray[childToSwap];
                    heapArray[childToSwap] = newValue;
                    startIndex = childToSwap;
                }
                else
                {
                    break;
                }
            } else {
                break;
            }
        }
    }

    @Deprecated
    // use with 2 params
    public void heapifyArrayBelow(int index) {
        int newValue = heapArray[index];

        while (index < size) {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);

            if (heapArray[leftChild] != null) {
                if (heapArray[leftChild] > newValue) {
                    heapArray[index] = heapArray[leftChild];
                    heapArray[leftChild] = newValue;
                    index = leftChild;


                } else if (heapArray[rightChild] != null && heapArray[rightChild] > newValue) {
                    heapArray[index] = heapArray[rightChild];
                    heapArray[rightChild] = newValue;
                    index = rightChild;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }

    private boolean isFull() {
        return size == heapArray.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public int getParent(int index) {
        return (index - 1) / 2;
    }

    public int getChild(int index, boolean left) {
        return left ? (2 * index + 1) : (2 * index + 2);
    }

    public Integer[] getHeapArray(){
        return heapArray;
    }

    public int getSize(){
        return size;
    }


}
