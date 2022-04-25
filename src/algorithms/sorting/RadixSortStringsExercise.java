package src.algorithms.sorting;

import src.common.CommonUtil;

public class RadixSortStringsExercise {

    public static void main(String[] args)
    {
        String[] unsortedArray = {"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};

        System.out.println("UnsortedArray: " + CommonUtil.printMyArray(unsortedArray));

        unsortedArray= radixSort(unsortedArray);

        System.out.println("SortedArray: " + CommonUtil.printMyArray(unsortedArray));
    }

    private static String[] radixSort(String[] unsortedArray)
    {
        String max = getMax(unsortedArray);

        for(int i=max.length()-1; i>=0; i--)
        {
            unsortedArray = sortByCharacter(unsortedArray, i);
        }
        return unsortedArray;
    }

    private static String getMax(String[] unsortedArray) {
        String max = "";
        for (int i = 0; i< unsortedArray.length; i++)
        {
            if(unsortedArray[i].length() > max.length())
                max = unsortedArray[i];
        }
        return max;
    }

    //{"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"}
    private static String[] sortByCharacter(String[] unsortedArray, int position)
    {
        int min=97; // ascii of lower 'a'
        int[] countArray = new int[26];

        for (int i=0; i<unsortedArray.length; i++)
        {
            int letterAscii = unsortedArray[i].charAt(position);
            countArray[letterAscii-97]++;
        }
        System.out.println("Count Array: " + CommonUtil.printMyArray(countArray));

        for (int i=1; i<countArray.length;i++)
        {
            countArray[i]=countArray[i] + countArray[i-1];
        }
        System.out.println("Count Array: " + CommonUtil.printMyArray(countArray));

        String[] sortedArray = new String[unsortedArray.length];

        for (int i=unsortedArray.length-1; i>=0; i--)
        {
            int letterAscii = unsortedArray[i].charAt(position);
            int letterPosition = countArray[letterAscii - 97];
            countArray[letterAscii-97]--;
            sortedArray[letterPosition-1] = unsortedArray[i];
        }
        return sortedArray;
    }


}
