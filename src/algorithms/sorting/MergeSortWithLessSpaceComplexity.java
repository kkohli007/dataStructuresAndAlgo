package src.algorithms.sorting;

import src.common.CommonUtil;

public class MergeSortWithLessSpaceComplexity {

    private static int[] unsortedArray = {20,-15,7,35,55,1,-22,7};

    public static void main(String[] args)
    {
        System.out.println("UnsortedArray: " + CommonUtil.printMyArray(unsortedArray));

        unsortedArray = mergeSort(unsortedArray, 0, unsortedArray.length-1);

        System.out.println("SortedArray: " + CommonUtil.printMyArray(unsortedArray));
    }

    private static int[] mergeSort(int[] myArray, int start, int end)
    {
        int mid = start + (end - start)/2;

        if(start==end)
        {
            return myArray;
        }
        // start:0, mid,0 end: 1
        mergeSort(myArray, start, mid);
        mergeSort(myArray, mid+1, end);

        if (myArray[mid] < myArray[mid+1])
        {
            System.out.println("Intermediate return: " + CommonUtil.printMyArray(unsortedArray));
            return myArray;
        }

        int[] tempArray = new int[end - start + 1];
        int x = start;
        int y = mid;
        for(int i= 0; i<tempArray.length; i++)
        {
            if(x>mid)
            {
                tempArray[i] = myArray[y+1];
                y++;
            }
            else if(y+1>end)
            {
                tempArray[i] = myArray[x];
                x++;
            }
            else if(myArray[x]<myArray[y+1])
            {
                tempArray[i] = myArray[x];
                x++;
            }
            else
            {
                tempArray[i] = myArray[y+1];
                y++;
            }
        }

        int counter = 0;
        for(int i=start; i<=end; i++)
        {
            myArray[i] = tempArray[counter];
            counter++;
        }

        System.out.println("Intermediate after merge: " + CommonUtil.printMyArray(unsortedArray));

        return myArray;
    }


}
