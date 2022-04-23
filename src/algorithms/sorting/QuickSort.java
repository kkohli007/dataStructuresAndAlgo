package src.algorithms.sorting;

import src.common.CommonUtil;

public class QuickSort {

    private static int[] unsortedArray = {95,13,47,52,41,68,42};

    public static void main(String[] args)
    {
        System.out.println("UnsortedArray: " + CommonUtil.printMyArray(unsortedArray));

        quickSort(unsortedArray, 0, unsortedArray.length-1);

        System.out.println("SortedArray: " + CommonUtil.printMyArray(unsortedArray));
    }

    private static void quickSort(int[] arr, int low, int high)
    {
        if (low>=high)
        {
            return;
        }

        int j = partition(arr, low, high);
        quickSort(arr,low, j-1);
        quickSort(arr,j+1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivotElement = arr[low];

        int i = low;
        int j = high;

        while (i < j)
        {
            while (arr[i] <= pivotElement && i< high)
            {
                i++;
            }

            while (arr[j] > pivotElement && j> low)
            {
                j--;
            }

            if(i<j)
            {
                CommonUtil.swap(arr, i, j);
            }
        }

        CommonUtil.swap(arr, low, j);
        return j;
    }
}
