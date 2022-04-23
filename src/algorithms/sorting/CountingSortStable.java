package src.algorithms.sorting;

import src.common.CommonUtil;

public class CountingSortStable {

    public static void main(String[] args)
    {
        int[] unsortedArrayInt = {1, 4, 1, 2, 7, 5, 2, 9, 8, 1};
        // int array sorting
        System.out.println("UnsortedArray: " + CommonUtil.printMyArray(unsortedArrayInt));
        int[] sortedArrayInt = sortIntArray(unsortedArrayInt);
        System.out.println("SortedArray: " + CommonUtil.printMyArray(sortedArrayInt));

        //POC
        String[] unsortedArrayString = {"1a", "4a", "1b", "2a", "7a", "5a", "2b","9a","8a","1c"};
        System.out.println("UnsortedArray: " + CommonUtil.printMyArray(unsortedArrayInt));
        String[] sortedArrayString = sortStringArray(unsortedArrayString);
        // {1a,1b,1c,2a,2b,4a,5a,7a,8a,9a}
        System.out.println("SortedArray: " + CommonUtil.printMyArray(sortedArrayString));
    }

    private static int[] sortIntArray(int[] unsortedArrayInt) {
        // we know range is 0-9
        int min = 0;
        int max = 9;

        int[] countArray = new int[max-min + 1];

        for(int i=0;i<unsortedArrayInt.length;i++)
        {
            int currentElementPosition=unsortedArrayInt[i]-min;
            countArray[currentElementPosition]++ ;
        }
        // Count array - [0,3,2,0,1,1,0,1,1,1]

        System.out.println("Countarray: " + CommonUtil.printMyArray(countArray));

        for(int i=1;i<countArray.length ;i++)
        {
            countArray[i] = countArray[i] + countArray[i-1];
        }

        System.out.println("Countarray: " + CommonUtil.printMyArray(countArray));

        int[] sortedArray = new int[unsortedArrayInt.length];

        // Count array - [0,3,5,5,6,7,7,8,9,10]
        for(int i=unsortedArrayInt.length-1;i>=0;i--)
        {
            int currentElementPositionInCountArray = unsortedArrayInt[i] - min;
            int elementPosition = countArray[currentElementPositionInCountArray];
            countArray[currentElementPositionInCountArray] = countArray[currentElementPositionInCountArray] -1;
            sortedArray[elementPosition-1] = unsortedArrayInt[i];
        }
        return sortedArray;
    }

    private static String[] sortStringArray(String[] unsortedArrayString) {
        // we know range is 0-9
        int min = 0;
        int max = 9;

        int[] countArray = new int[max-min + 1];

        for(int i=0;i<unsortedArrayString.length;i++)
        {
            int currentElementPosition=getDigit(unsortedArrayString[i])-min;
            countArray[currentElementPosition]++ ;
        }
        // Count array - [0,3,2,0,1,1,0,1,1,1]

        System.out.println("Countarray: " + CommonUtil.printMyArray(countArray));

        for(int i=1;i<countArray.length ;i++)
        {
            countArray[i] = countArray[i] + countArray[i-1];
        }

        System.out.println("Countarray: " + CommonUtil.printMyArray(countArray));

        String[] sortedArray = new String[unsortedArrayString.length];

        // Count array - [0,3,5,5,6,7,7,8,9,10]
        for(int i=unsortedArrayString.length-1;i>=0;i--)
        {
            int currentElementPositionInCountArray = getDigit(unsortedArrayString[i]) - min;
            int elementPosition = countArray[currentElementPositionInCountArray];
            countArray[currentElementPositionInCountArray] = countArray[currentElementPositionInCountArray] -1;
            sortedArray[elementPosition-1] = unsortedArrayString[i];
        }
        return sortedArray;
    }

    private static int getDigit(String s) {
        return Integer.parseInt(String.valueOf(s.charAt(0)));
    }
}
