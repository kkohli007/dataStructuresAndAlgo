package src.common;

import java.util.ArrayList;

public class CommonUtil {

    public static String printMyArray(int[] unsortedArray)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int j =0; j < unsortedArray.length; j++)
        {
            sb.append(unsortedArray[j] + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    public static String printMyArray(String[] unsortedArray)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int j =0; j < unsortedArray.length; j++)
        {
            sb.append(unsortedArray[j] + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    public static void swap(int[] myArray, int i, int j) {
        int temp = myArray[i];
        myArray[i] = myArray[j];
        myArray[j] = temp;
    }

    public static void swap(ArrayList<Integer> myList, int i, int j) {
        int temp = myList.get(i);
        myList.set(i, myList.get(j));
        myList.set(j, temp);
    }

    public static String printMyArrayList(ArrayList<Integer> bucket)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i: bucket)
        {
            sb.append(i + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }
}
