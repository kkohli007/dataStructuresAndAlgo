package src.algorithms.sorting;

import src.common.CommonUtil;

public class QuickSort {

    private static int[] unsortedArray = {20,35,-15,7,55,1,-22,7};

    public static void main(String[] args)
    {
        System.out.println("UnsortedArray: " + CommonUtil.printMyArray(unsortedArray));

        unsortedArray = quickSort(unsortedArray, 0, unsortedArray.length-1);

        System.out.println("SortedArray: " + CommonUtil.printMyArray(unsortedArray));
    }

    private static int[] quickSort(int[] myArray, int start, int end)
    {
        System.out.println("Start Printing array:" + CommonUtil.printMyArray(myArray));

        if (start>=end)
        {
            return myArray;
        }

        int pivotElement =myArray[start];

        int i = start+1;
        int j = end;

        while (i < j)
        {
            while (myArray[i] <= pivotElement && i<end)
            {
                i++;
            }

            while (myArray[j] >= pivotElement && j>start)
            {
                j--;
            }

            if(i<j)
            {
                CommonUtil.swap(myArray, i, j);
                i++; j--;
            }
        }

        if(myArray[start] > myArray[j])
        {
            CommonUtil.swap(myArray, start, j);
        }



        quickSort(myArray,start, j-1);
        quickSort(myArray,j+1, end);

        System.out.println("End Printing mergedArray:" + CommonUtil.printMyArray(myArray));

        return myArray;
    }


}
