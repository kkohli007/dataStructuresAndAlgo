package src.algorithms.sorting;

import src.common.CommonUtil;

import java.util.ArrayList;

public class BucketSort {


    public static void main(String[] args)
    {
        int[] unsortedArray = {11,9,21,8,17,19,13,1,24,12};
        System.out.println("UnsortedArray: " + CommonUtil.printMyArray(unsortedArray));

        //create 5 buckets, 0-4, 5-9, 10-14, 15-19, 20-24,, range is given.
        unsortedArray = bucketSort(unsortedArray, 5);

        System.out.println("SortedArray: " + CommonUtil.printMyArray(unsortedArray));
    }

    private static int[] bucketSort(int[] unsortedArray, int buckets)
    {
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();

        //Step 1 :: Scatter
        fillBucketList(unsortedArray, buckets, bucketList);

        //Step 2 :: Sort
        sortBucket(bucketList);

        //Step 3 :: Concatenate
        unsortedArray = concatenateBucketElements(bucketList, unsortedArray.length);
        return unsortedArray;
    }

    private static void fillBucketList(int[] unsortedArray, int buckets, ArrayList<ArrayList<Integer>> bucketList) {
        for(int i = 0; i< buckets; i++)
        {
            bucketList.add(i, new ArrayList<>());
        }

        for(int i = 0; i< unsortedArray.length; i++)
        {
            bucketList.get(unsortedArray[i]/ buckets).add(unsortedArray[i]);
        }

        System.out.println("::UnSortedBucketList::");
        for(ArrayList<Integer> bucket: bucketList)
        {
            System.out.println("UnSortedBucket: " + CommonUtil.printMyArrayList(bucket));
        }
        System.out.println();
    }

    private static void sortBucket(ArrayList<ArrayList<Integer>> bucketList)
    {
        for(ArrayList<Integer> bucket: bucketList)
        {
            InsertionSort.insertionSort(bucket);
            System.out.println("SortedBucket: " + CommonUtil.printMyArrayList(bucket));
        }
    }

    private static int[] concatenateBucketElements(ArrayList<ArrayList<Integer>> bucketList, int length)
    {
        int sortedArray[] = new int[length];
        int i=0;

        for(ArrayList<Integer> bucket: bucketList)
        {
            for (int number: bucket)
            {
                sortedArray[i] = number;
                i++;
            }
        }
        return sortedArray;
    }

}
