package com.example.demo.array.sorts;

import com.example.demo.util.CommonUtil;
import com.example.demo.util.Pair;

public class QuickSort {

    private static int count;

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5,4,2,3};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is the partition return index of pivot
            int pi = partitionMid(arr, low, high);
            // Recursion calls for smaller elements
            // and greater or equals elements
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partitionMid(int[] arr, int low, int high) {
        Pair<Integer, Integer> midValIndex= CommonUtil.getMidValueFromUnArray(arr, low,high+1);
        int piVot=midValIndex.getKey();

        int piIndex=midValIndex.getValue();
        System.out.println(piIndex+" "+piVot);

        // Index of smaller element and indicates the correct position of pivot found so far
        int i=low-1;

        for(int j=low;j<=high;j++) {
            if(arr[j] < piVot ) {
                ++i;
                if (i == piIndex) {
                    piIndex=j;
                }
                CommonUtil.swap(arr, i,j);
            }
        }

        CommonUtil.swap(arr, i+1,piIndex );
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println(++count);
        return i+1;
    }

    private static int partition(int[] arr, int low, int high) {
        int piVot=arr[high];

        // Index of smaller element and indicates the correct position of pivot found so far
        int i=low-1;

        for(int j=low;j<=high;j++) {
            if(arr[j] < piVot ) {
                ++i;
                CommonUtil.swap(arr, i,j);
            }
        }

        CommonUtil.swap(arr, i+1,high );
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println(++count);
        return i+1;
    }

}
