package src.algorithms.searching;

import src.algorithms.sorting.MergeSort;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {20,-15,7,35,55,1,-22};

        // first requirement for binary search to have sorted array
        int[] sortedArray = MergeSort.mergeSort(array);

        int position = searchElement(55, 0, sortedArray.length, sortedArray);
        System.out.println("Element 55 present at : " + position);

        position = searchElement(-22, 0, sortedArray.length, sortedArray);
        System.out.println("Element 88 present at : " + position);

        position = searchElement(88, 0, sortedArray.length, sortedArray);
        System.out.println("Element 88 present at : " + position);

        // Search Iterative
        position = searchElementIterative(55, sortedArray);
        System.out.println("Element 55 present at : " + position);

        position = searchElementIterative(-22, sortedArray);
        System.out.println("Element 88 present at : " + position);

        position = searchElementIterative(88, sortedArray);
        System.out.println("Element 88 present at : " + position);

    }

    public static int searchElement(int num, int start, int end, int[] array)
    {
        if(start == end)
        {
            return -1;
        }

        int middle = (end + start)/2;

        // search middle
        if(array[middle] == num)
        {
            System.out.println("Element " + num + " found" );
            return middle;
        }
        else if (array[middle] > num)
        {
            return searchElement(num, start, middle, array);
        }
        else
        {
            return searchElement(num, middle + 1, end, array);
        }
    }

    public static int searchElementIterative(int num, int[] array)
    {
        int start = 0;
        int end = array.length;
        while(start<end)
        {
            int middle = (end + start)/2;

            // search middle
            if(array[middle] == num)
            {
                System.out.println("Element " + num + " found" );
                return middle;
            }
            else if (array[middle] > num)
            {
                end = middle;
            }
            else
            {
                start = middle + 1;
            }

        }
        return -1;
    }
}
