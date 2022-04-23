package src.algorithms.sorting;

import src.common.CommonUtil;

public class CountingSortStable {

    private static String[] unsortedArray = {"1a", "4a", "1b", "2a", "7a", "5a", "2b","9a","8a","1c"};

    public static void main(String[] args)
    {
        System.out.println("UnsortedArray: " + CommonUtil.printMyArray(unsortedArray));

        // we know range is 0-9
        int min = 0;
        int max = 9;

        int[] countArray = new int[max-min + 1];

        for(int i=0;i<unsortedArray.length;i++)
        {
            int currentElementPosition=getDigit(unsortedArray[i])-min;
            countArray[currentElementPosition]++ ;
        }
        // Count array - [0,3,2,0,1,1,0,1,1,1]

        System.out.println("Countarray: " + CommonUtil.printMyArray(countArray));

        for(int i=1;i<countArray.length ;i++)
        {
            countArray[i] = countArray[i] + countArray[i-1];
        }

        System.out.println("Countarray: " + CommonUtil.printMyArray(countArray));

        String[] sortedArray = new String[unsortedArray.length];

        // Count array - [0,3,5,5,6,7,7,8,9,10]
        for(int i=unsortedArray.length-1;i>=0;i--)
        {
            int currentElementPositionInCountArray = getDigit(unsortedArray[i]) - min;
            int elementPosition = countArray[currentElementPositionInCountArray];
            countArray[currentElementPositionInCountArray] = countArray[currentElementPositionInCountArray] -1;
            sortedArray[elementPosition-1] = unsortedArray[i];
        }

        // {1a,1b,1c,2a,2b,4a,5a,7a,8a,9a}
        System.out.println("SortedArray: " + CommonUtil.printMyArray(sortedArray));
    }

    private static int getDigit(String s) {
        return Integer.parseInt(String.valueOf(s.charAt(0)));
    }
}
