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
