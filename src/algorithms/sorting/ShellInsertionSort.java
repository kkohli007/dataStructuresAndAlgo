package src.algorithms.sorting;

import src.common.CommonUtil;

public class ShellInsertionSort {

    private static int[] unsortedArray = {20, 35, -15, 7, 55, 1, -22};

    public static void main(String[] args)
    {
        System.out.println("UnsortedArray: " + CommonUtil.printMyArray(unsortedArray));

        int gap = unsortedArray.length/2;

        while(gap>0)
        {
            for(int i = gap; i<unsortedArray.length; i++)
            {
                int currentElementPosition = i;
                for(int j=i-gap; j>=0; j=j-gap)
                {
                    if(unsortedArray[currentElementPosition]<unsortedArray[j])
                    {
                        CommonUtil.swap(unsortedArray, currentElementPosition, j);
                        currentElementPosition = j;
                    }
                    else
                    {
                        break;
                    }
                }
            }
            gap = gap/2;
        }
        System.out.println("SortedArray: " + CommonUtil.printMyArray(unsortedArray));
    }
}
