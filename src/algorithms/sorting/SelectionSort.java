package src.algorithms.sorting;

import src.common.CommonUtil;

public class SelectionSort {

    private static int[] unsortedArray = {20,-15,7,35,55,1,-22};

    public static void main(String[] args)
    {
        System.out.println("UnsortedArray: " + CommonUtil.printMyArray(unsortedArray));

        int lastUnsortedPosition = unsortedArray.length - 1;
        while (lastUnsortedPosition > 0)
        {
            int largestElementPosition = 0;
            for (int i=1; i <= lastUnsortedPosition; i++)
            {
                if (unsortedArray[largestElementPosition] < unsortedArray[i])
                {
                    largestElementPosition = i;
                }
            }
            CommonUtil.swap(unsortedArray, largestElementPosition, lastUnsortedPosition);
            lastUnsortedPosition--;
        }
        System.out.println("SortedArray: " + CommonUtil.printMyArray(unsortedArray));
    }
}
