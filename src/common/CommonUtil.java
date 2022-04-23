package src.common;

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

    public static void swap(int[] unsortedArray, int i, int j) {
        int temp = unsortedArray[i];
        unsortedArray[i] = unsortedArray[j];
        unsortedArray[j] = temp;
    }

}
