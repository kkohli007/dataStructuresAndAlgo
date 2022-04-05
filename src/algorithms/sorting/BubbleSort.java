package src.algorithms.sorting;

import src.common.CommonUtil;

public class BubbleSort {

    private static int[] unsortedArray = {20,-15,7,35,55,1,-22};

    public static void main(String[] args)
    {
        System.out.println("UnsortedArray: " + CommonUtil.printMyArray(unsortedArray));

        int unsortedPosition = unsortedArray.length - 1;

        while (unsortedPosition>0)
        {
            for (int i=0; i <= unsortedPosition - 1; i++)
            {
                if(unsortedArray[i] > unsortedArray[i+1])
                {
                    CommonUtil.swap(unsortedArray, i, i+1);
                }
            }
            unsortedPosition--;
        }

        System.out.println("SortedArray: " + CommonUtil.printMyArray(unsortedArray));
    }
}
