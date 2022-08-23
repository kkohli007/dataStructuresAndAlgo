package src.geeksForGeeksProblems.easy;

import src.common.CommonUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayProblems2 {

    public static void main(String[] args) {

        // rotate array
        int array[] = {1,2,3,4,5};
        rotate(array,5);
        System.out.println(CommonUtil.printMyArray(array));

        // reverse in groups array
        Integer array1[] = new Integer[] {1,2,3,4,5};
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(array1));
        reverseInGroups(intList, 5, 2);
        System.out.println(CommonUtil.printMyArrayList(intList));

        // find min distance
        int array2[] = {2,1,3,2};
        System.out.println(minDist(array2, 4, 2, 3));
    }

    // O(n)
    public static void rotate(int arr[], int n)
    {
        /*if(n<=1)
            return;
        int prevValue= arr[0];
        int currValue;
        for(int i=1;i<n; i++)
        {
            currValue=arr[i];
            arr[i] = prevValue;
            prevValue = currValue;
        }
        arr[0] = prevValue;*/

        if(n==0)
            return;
        int last = arr[n - 1];

        for(int i=n-1; i>0; i--)
            arr[i] = arr[i-1];

        arr[0] = last;
    }

    // 1,2,3,4,5
    /*
    Time complexity = n/k * k/2 == n/2 == n
    Space complexity = O(1)
     */
    public static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {

        int groups = (int) Math.ceil((double) n/k);

        for(int i=1; i<=groups; i++)
        {
            int start= k*i - k;
            int end= k*i - 1;
            while(end>=n)
                end--;

            while(start<end)
            {
                Integer temp = arr.get(start);
                arr.set(start, arr.get(end));
                arr.set(end, temp);
                start++;
                end--;
            }
        }
    }

    public static int minDist(int a[], int n, int x, int y) {
        Integer posX=null;
        Integer posY=null;
        int minDist=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            if(a[i]==x)
                posX=i;
            else if(a[i]==y)
                posY=i;

            if(posX!=null && posY!=null)
                minDist = Math.min(minDist, Math.abs(posX-posY));
        }
        if(posX!=null && posY!=null)
            return minDist;
        else
            return -1;
    }

}
