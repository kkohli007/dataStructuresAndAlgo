package src.geeksForGeeksProblems.easy;

import src.common.CommonUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class ArrayProblems1 {

    public static void main(String[] args) {

        // find if all array elements are palindrome
        int[] arr = {111, 222, 330, 444, 555};
        System.out.println(palinArray(arr, 5));

        // print alternate elements
        int array[] = {1, 2, 3, 4, 5};
        print(array, 4);

        System.out.println();
        // binary search
        int bsarray[] = {1, 2, 3, 4, 5};
        System.out.println(binarysearch(bsarray, 5, 4));

        //FInd triplet with sum of 0
        int tripletarray[] = {0, 9, -1, -3, 1};
        System.out.println(findTriplets(tripletarray, 5));
        System.out.println(findTripletsBySorting(tripletarray, 5));

        // Find union and intersection of two arrays
        int a[] = {1, 1, 2, 3, 4, 5};
        int b[] = {1, 2, 2, 3};
        System.out.println(doUnion(a, 6, b, 4));
        System.out.println(CommonUtil.printMyArray(doUnionOptimizedSortedSet(a, 6, b, 4)));
        System.out.println(CommonUtil.printMyArray(doIntersection(a, 6, b, 4)));

        // Maximize
        int array1[] = {5, 3, 2, 4, 1};
        System.out.println(Maximize(array1, 5));
        /*try
        {
            BufferedReader br = new BufferedReader(new FileReader("/Users/kkohli/Downloads/input.txt"));
            int n = Integer.parseInt(br.readLine());
            int array2[] = new int[n];
            String line = br.readLine();
            String[] arra = line.split(" ");
            for (int i = 0; i < n; i++) {
                array2[i] = Integer.parseInt(arra[i]);
            }
            System.out.println("Before::" + CommonUtil.printMyArray(array2));
            System.out.println(Maximize(array2, n));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }*/

        // zigZag
        int array2[] = {1, 4, 3, 2};
        zigZag(array2, 4);
        System.out.println(CommonUtil.printMyArray(array2));
    }

    // O(n)
    static  void zigZag(int arr[], int n) {
        // code here
        for(int i=0;i<n-1;i++)
        {
            if(i%2==0 && arr[i]>arr[i+1])
            {
                CommonUtil.swap(arr, i, i+1);
            }
            else if(i%2==1 && arr[i]<arr[i+1])
            {
                CommonUtil.swap(arr, i, i+1);
            }
        }
        /*
         In this approach, rather than sorting the complete array,
         we will maintain a flag for representing which order(i.e.,< or >) we currently need.
         If the current two elements are not in that order, then swap those elements, otherwise not.
         Algo:
            Set the flag to true.
            Traverse over the array from 0 to n-2 (where n is the length of the array).
            Check if the flag is true
                Check if the current element is greater than the next element.
                Swap those values.
            Else, check if the current element is greater than the next element.
                Check if the current element is lesser than the next element.
                Swap those values.
            Flip the value of the flag.
         */
    }

    public static int palinArray(int[] a, int n)
    {
        for(int i =0; i<a.length; i++)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(a[i]);
            if(!sb.toString().equals(sb.reverse().toString()))
                return 0;
        }
        return 1;
    }

    public static void print(int arr[], int n)
    {
        for (int i =0 ; i<arr.length; i=i+2)
            System.out.print(arr[i] + " ");
        // your code here
    }

    // O(logn) time and O(1) space
    public static int binarysearch(int arr[], int n, int k) {

        int start = 0;
        int end = arr.length;

        while(start<end)
        {
            int middle = (start + end)/2;
            if(arr[middle] == k)
                return middle;
            else if (arr[middle] > k)
            {
                end = middle;
            }
            else
            {
                start = middle + 1;
            }
        }
        return -1;
    }


    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
    // O(nˆ2) time, O(n) space
    public static boolean findTriplets(int arr[] , int n)
    {
        Set<Integer> complementSet = new HashSet<>();

        for(int i=0; i< arr.length - 2 ; i++)
        {
            complementSet.clear();
            for(int j=i+1; j< arr.length ; j++)
            {
                if(complementSet.contains(arr[j]))
                    return true;
                else
                    complementSet.add(-arr[i] - arr[j]);
            }
        }
        return false;
    }

    // O(nˆ2) time, O(1) space
    public static boolean findTripletsBySorting(int arr[] , int n)
    {
        Arrays.sort(arr);

        for(int i=0; i< arr.length ; i++)
        {
            int low = i+1;
            int high = arr.length-1;

            while(low<high)
            {
                if(arr[i] + arr[low] + arr[high] == 0)
                    return true;

                if(arr[i] + arr[low] + arr[high] > 0)
                    high --;
                else
                    low ++;
            }
        }
        return false;
    }

    // Space O(m + n)
    // linked hashset will be O(1) and maintains input order, so perfect for sorted array. Total O(m + n)
    // hashset will be O(1) time but no order, Total O(m + n)
    // treeset will be O(logn) time but ordered, total O(mlogm + nlogn). Can use for unsorted array.
    public static int doUnion(int a[], int n, int b[], int m)
    {
        Set<Integer> finalSet = new LinkedHashSet<>();
        //Set<Integer> finalSet = new HashSet<>();
        //Set<Integer> finalSet = new TreeSet<>();

        for(int i=0; i<n; i++)
            finalSet.add(a[i]);
        for(int j=0; j<m; j++)
            finalSet.add(b[j]);

        return finalSet.size();

        // this can be optimized little bit if we iterate first time with minimum of m or n and add elements to set from both array
        // then second time iterate for remaining elements for bigger array. then it will be O(max(m,n)) instead of O(m+n)
    }

    // O(n + m) time. Space O(m + n)
    public static int[] doUnionOptimizedSortedSet(int a[], int n, int b[], int m)
    {
        int combinedArray[] = new int[n + m];

        int i=0,j=0,combinedArraySize=0;
        while(i<n && j<m)
        {
            if(combinedArraySize>0 && a[i] == combinedArray[combinedArraySize-1])
            {
                i++;
                continue;
            }
            else if(combinedArraySize>0 && b[j] == combinedArray[combinedArraySize-1])
            {
                j++;
                continue;
            }

            if(a[i]<b[j])
            {
                combinedArray[combinedArraySize++] = a[i++];
            }
            else
                combinedArray[combinedArraySize++] = b[j++];
        }

        while(i<n)
        {
            if(combinedArraySize>0 && a[i] == combinedArray[combinedArraySize-1])
            {
                i++;
                continue;
            }
            combinedArray[combinedArraySize++] = a[i++];
        }
        while(j<m)
        {
            if(combinedArraySize>0 && b[j] == combinedArray[combinedArraySize-1])
            {
                j++;
                continue;
            }
            combinedArray[combinedArraySize++] = b[j++];
        }
        return combinedArray;
    }

    public static Integer[] doIntersection(int a[], int n, int b[], int m)
    {
        // treeset will be O(logn) time but ordered,
        // hashset for o(1) but unordefred
        // linkedhashset maintains order, and since array is already ordered, no probl O(1)
        // time complexity O(min(m,n))
        // space complexity will be O(min(m,n))
        Set<Integer> intersectionSet = new LinkedHashSet<>();

        int i=0,j=0;

        while(i<n && j<m)
        {
            if(a[i]<a[j])
                i++;
            else if(a[i]>a[j])
                j++;
            else
            {
                intersectionSet.add(a[i]);
                i++;
                j++;
            }
        }
        return intersectionSet.toArray(new Integer[0]);
    }

    static int Maximize(int arr[], int n)
    {
        // Complete the function
        Arrays.sort(arr);

        long sum=0;
        int M = (int) Math.pow(10,9) + 7;
        for(int i=0; i<n; i++)
        {
            sum = (sum + ((long)arr[i] * i)) % M;
        }
        return (int) sum;
    }
}
