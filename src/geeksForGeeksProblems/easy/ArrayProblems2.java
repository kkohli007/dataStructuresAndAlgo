package src.geeksForGeeksProblems.easy;

import com.sun.deploy.panel.DeleteFilesDialog;
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

        // find first and last occurrence
        long array3[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
        System.out.println(CommonUtil.printMyArrayListLong(find(array3, 9, 5)));
        System.out.println(CommonUtil.printMyArrayListLong(findFirstLastOccurrence(array3, 9, 5)));

        // third largest element in array
        int array4[] = {2,4,1,3,5};
        System.out.println(thirdLargest(array4, array4.length));
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

    // { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
    public static ArrayList<Long> find(long arr[], int n, int x)
    {
        //int lowestOcc = Integer.MAX_VALUE;
        //int highestOcc = Integer.MIN_VALUE;

        ArrayList<Long> resultList = new ArrayList<>(2);
        resultList.add(Long.MAX_VALUE);
        resultList.add(Long.MIN_VALUE);

        findRecursive(arr, 0, n, x, resultList);

        if(resultList.get(0) == Long.MAX_VALUE)
        {
            resultList.set(0, Long.valueOf(-1));
            resultList.set(1, Long.valueOf(-1));
        }

        return resultList;
    }

    static ArrayList<Long> findRecursive(long arr[], int start, int end, int x, ArrayList<Long> resultList)
    {
        if(start==end)
            return resultList;

        int middle = (start + end)/2;

        if(arr[middle] == x)
        {
            resultList.set(0, Math.min(resultList.get(0),middle));
            resultList.set(1, Math.max(resultList.get(1),middle));

            //check left
            findRecursive(arr, start, middle, x, resultList);

            //check right
            findRecursive(arr, middle+1, end, x, resultList);
        }
        else if(arr[middle] < x)
        {
            //check right
            findRecursive(arr, middle+1, end, x, resultList);
        }
        else
        {
            //check left
            findRecursive(arr, start, middle, x, resultList);
        }
        return resultList;
    }


    // { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
    public static ArrayList<Long> findFirstLastOccurrence(long arr[], int n, int x)
    {

        ArrayList<Long> resultList = new ArrayList<>(2);

        int firstPos = findFirstOccurrence(arr, 0, n, x);
        int lastPos = findLastOccurrence(arr, 0, n, x);

        resultList.add(Long.valueOf(firstPos));
        resultList.add(Long.valueOf(lastPos));

        return resultList;
    }

    public static int findFirstOccurrence(long arr[], int low, int high, int x)
    {
        if(low==high)
            return -1;
        int mid = low + (high-low)/2;

        if(arr[mid] == x && (mid == 0 || arr[mid-1]<x))
        {
            return mid;
        }
        else if(arr[mid] < x)
        {
            return findFirstOccurrence(arr, mid+1, high, x);
        }
        else
        {
            return findFirstOccurrence(arr, low, mid, x);
        }
    }

    public static int findLastOccurrence(long arr[], int low, int high, int x)
    {
        if(low==high)
            return -1;
        int mid = low + (high-low)/2;

        if(arr[mid] == x && (mid == arr.length-1 || arr[mid+1]>x))
        {
            return mid;
        }
        else if(arr[mid] > x)
        {
            return findLastOccurrence(arr, low, mid, x);
        }
        else
        {
            return findLastOccurrence(arr, mid+1, high, x);
        }
    }
    static int thirdLargest(int a[], int n)
    {
        if(n<3)
            return -1;
        // Your code here
        int first = a[0];
        int second = -1;
        int third = -1;

        for(int i=1; i<n; i++)
        {
            if(a[i]> first)
            {
                third = second;
                second = first;
                first = a[i];
            }
            else if(a[i] > second)
            {
                third = second;
                second = a[i];
            }
            else if(a[i] > third)
            {
                third = a[i];
            }
        }
        return third;
    }

}
