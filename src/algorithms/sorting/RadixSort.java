package src.algorithms.sorting;

import src.common.CommonUtil;

public class RadixSort {

    public static void main(String[] args)
    {
        int[] unsortedArray = {4725,4586,1330,8792,1594,5729};

        System.out.println("UnsortedArray: " + CommonUtil.printMyArray(unsortedArray));

        unsortedArray= radixSort(unsortedArray);

        System.out.println("SortedArray: " + CommonUtil.printMyArray(unsortedArray));
    }

    private static int[] radixSort(int[] unsortedArray)
    {
        int max = getMaximumElement(unsortedArray);

        for(int exp=1; max/exp>0; exp*=10)
        {
            unsortedArray = countSort(unsortedArray, exp);
        }
        return unsortedArray;
    }

    private static int getMaximumElement(int[] unsortedArray)
    {
        int max = unsortedArray[0];
        for(int i =1; i<unsortedArray.length; i++)
        {
            if(unsortedArray[i]>max)
                max=unsortedArray[i];
        }
        return max;
    }

    private static int[] countSort(int[] unsortedArray, int exp)
    {
        //{4725,4586,1330,8792,1594,5729};
        // we know range is 0-9
        int[] countArray = new int[10];

        for(int i=0;i<unsortedArray.length;i++)
        {
            int digit = (unsortedArray[i] / exp) % 10;
            countArray[digit]++;
        }
        // Count array - [1,0,1,0,1,1,1,0,0,1]

        System.out.println("Countarray: " + CommonUtil.printMyArray(countArray));

        for(int i=1;i<countArray.length ;i++)
        {
            countArray[i] = countArray[i] + countArray[i-1];
        }

        // Count array - [1,1,2,2,3,4,5,5,5,6]

        System.out.println("Countarray: " + CommonUtil.printMyArray(countArray));

        int[] sortedArray = new int[unsortedArray.length];

        // Count array - [0,3,5,5,6,7,7,8,9,10]
        for(int i=unsortedArray.length-1;i>=0;i--)
        {
            int digit = (unsortedArray[i]/exp)%10;
            int elementPosition = countArray[digit];
            countArray[digit] = countArray[digit] -1;
            sortedArray[elementPosition-1] = unsortedArray[i];
        }
        System.out.println("IntermediateArray: " + CommonUtil.printMyArray(sortedArray));
        return sortedArray;
    }
}
