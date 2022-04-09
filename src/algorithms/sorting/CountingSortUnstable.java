package src.algorithms.sorting;

import src.common.CommonUtil;

import java.util.Arrays;

public class CountingSortUnstable {

    private static int[] unsortedArray = {12,15,19,18,12,18,17,20,14};

    public static void main(String[] args)
    {
        System.out.println("UnsortedArray: " + CommonUtil.printMyArray(unsortedArray));

        // we know range is 11-20
        int min = 11;
        int max = 20;

        int[] countArray = new int[max-min + 1];

        for(int i=0;i<unsortedArray.length;i++)
        {
            int currentElementPosition=unsortedArray[i]-min;
            countArray[currentElementPosition]++ ;
        }

        System.out.println("Countarray: " + CommonUtil.printMyArray(countArray));

        int x=0;
        for(int j=0; j<countArray.length;j++)
        {
            int numberOfValues = countArray[j];

            while(numberOfValues>0)
            {
                unsortedArray[x++]=j+min;
                numberOfValues--;
            }
        }

        System.out.println("SortedArray: " + CommonUtil.printMyArray(unsortedArray));
    }
}
