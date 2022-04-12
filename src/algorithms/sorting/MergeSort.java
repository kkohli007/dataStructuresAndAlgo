package src.algorithms.sorting;

import src.common.CommonUtil;

public class MergeSort {

    private static int[] unsortedArray = {20,-15,7,35,55,1,-22};

    public static void main(String[] args)
    {
        System.out.println("UnsortedArray: " + CommonUtil.printMyArray(unsortedArray));

        unsortedArray = mergeSort(unsortedArray);

        System.out.println("SortedArray: " + CommonUtil.printMyArray(unsortedArray));
    }

    private static int[] mergeSort(int[] array)
    {
        System.out.println("Start Printing array:" + CommonUtil.printMyArray(array));
        if(array.length==1)
        {
            return new int[]{array[0]};
        }

        int mid = (array.length/2)-1;

        int[] leftArray = splitArray(array, 0, mid);
        leftArray = mergeSort(leftArray);

        int[] rightArray = splitArray(array, mid+1, array.length-1);
        rightArray = mergeSort(rightArray);

        int[] mergedArray = new int[leftArray.length+rightArray.length];

        int leftArrayCounter = 0;
        int rightArrayCounter = 0;
        for (int i=0;i<mergedArray.length;i++)
        {
            if(leftArrayCounter>=leftArray.length)
            {
                mergedArray[i]=rightArray[rightArrayCounter];
                rightArrayCounter++;
            }
            else if(rightArrayCounter>=rightArray.length)
            {
                mergedArray[i]=leftArray[leftArrayCounter];
                leftArrayCounter++;
            }
            else if(leftArray[leftArrayCounter] < rightArray[rightArrayCounter])
            {
                mergedArray[i] = leftArray[leftArrayCounter];
                leftArrayCounter++;
            }
            else
            {
                mergedArray[i] = rightArray[rightArrayCounter];
                rightArrayCounter++;
            }
        }

        System.out.println("End Printing mergedArray:" + CommonUtil.printMyArray(mergedArray));

        return mergedArray;
    }

    private static int[] splitArray(int[] array, int start, int end)
    {
        System.out.println("Start split array:"
                + CommonUtil.printMyArray(array) + " ,start:" + start + " ,end:" + end);

        int[] splitArray = new int[end-start+1];

        for(int i=0, j=start; j<=end; i++, j++)
        {
            splitArray[i] = array[j];
        }

        System.out.println("end split array:"
                + CommonUtil.printMyArray(splitArray) + " ,start:" + start + " ,end:" + end);

        return splitArray;
    }
}
