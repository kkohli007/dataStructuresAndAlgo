package src.algorithms.sorting;

import src.common.CommonUtil;

import java.util.ArrayList;

public class InsertionSort {

    public static void main(String[] args)
    {
        int[] unsortedArray = {20,-15,7,35,55,7,1,-22};

        System.out.println("UnsortedArray: " + CommonUtil.printMyArray(unsortedArray));

        unsortedArray= insertionSort(unsortedArray);

        System.out.println("SortedArray: " + CommonUtil.printMyArray(unsortedArray));

        System.out.println("------Recursion------");

        int[] unsortedArray2 = {20,-15,7,35,55,7,1,-22};

        System.out.println("UnsortedArray: " + CommonUtil.printMyArray(unsortedArray2));

        unsortedArray2= insertionSortUsingRecursion(unsortedArray2, unsortedArray2.length);

        System.out.println("SortedArray: " + CommonUtil.printMyArray(unsortedArray2));
    }

    /*
        Algo:: sort n items, but first sort n-1 items... until 1 item
        so by the time when we are sorting nth item, we would have sorted first n-1 items
        while sorting nth item, find correct insertion point while going back.
     */
    private static int[] insertionSortUsingRecursion(int[] unsortedArray, int numOfItems)
    {
        //{20,-15,7,35,55,7,1,-22}

        if (numOfItems < 2)
            return unsortedArray;

        insertionSortUsingRecursion(unsortedArray, numOfItems-1);

        for(int i=numOfItems-2; i>=0 && unsortedArray[i] > unsortedArray[i+1]; i--)
        {
            CommonUtil.swap(unsortedArray, i, i+1);
        }
        System.out.println("SortedArray intermediate: " + CommonUtil.printMyArray(unsortedArray) + " when numOfItems:" + numOfItems);
        return unsortedArray;
    }

    public static int[] insertionSort(int[] unsortedArray) {
        for(int i = 1; i<unsortedArray.length; i++)
        {
            int currentElementPosition = i;
            for(int j=i-1; j>=0; j--)
            {
                if(unsortedArray[currentElementPosition]<unsortedArray[j])
                {
                    CommonUtil.swap(unsortedArray, currentElementPosition, j);
                    currentElementPosition --;
                }
                else
                {
                    break;
                }
            }
            System.out.println("SortedArray intermediate: " + CommonUtil.printMyArray(unsortedArray));
        }
        return unsortedArray;
    }

    public static void insertionSort(ArrayList<Integer> unsortedArrayList) {
        for(int i = 1; i<unsortedArrayList.size(); i++)
        {
            int currentElementPosition = i;
            for(int j=i-1; j>=0; j--)
            {
                if(unsortedArrayList.get(currentElementPosition)<unsortedArrayList.get(j))
                {
                    CommonUtil.swap(unsortedArrayList, currentElementPosition, j);
                    currentElementPosition --;
                }
                else
                {
                    break;
                }
            }
        }
    }
}
