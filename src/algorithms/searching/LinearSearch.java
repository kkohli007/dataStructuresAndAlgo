package src.algorithms.searching;

import src.algorithms.sorting.MergeSort;

public class LinearSearch {

    public static void main(String[] args) {
        int[] array = {20,-15,7,35,55,1,-22};

        int position = searchElement(55, array);
        System.out.println("Element 55 present at : " + position);

        position = searchElement(88, array);
        System.out.println("Element 88 present at : " + position);
    }

    private static int searchElement(int num, int[] array)
    {
        for(int i=0; i<array.length; i++)
        {
            if(array[i] == num)
            {
                System.out.println("Element " + num + " found" );
                return i;
            }
        }
        System.out.println("Element " + num + " not found" );
        return -1;
    }
}
