package src.algorithms.sorting;

import src.common.CommonUtil;

public class InsertionSort {

    private static int[] unsortedArray = {20,-15,7,35,55,7,1,-22};

    public static void main(String[] args)
    {
        System.out.println("UnsortedArray: " + CommonUtil.printMyArray(unsortedArray));

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

        System.out.println("SortedArray: " + CommonUtil.printMyArray(unsortedArray));
    }
}
