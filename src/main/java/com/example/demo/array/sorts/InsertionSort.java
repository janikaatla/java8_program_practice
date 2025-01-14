package com.example.demo.array.sorts;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5,4,2,3};
        int n = arr.length;

        insertSort(arr);

        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    private static void insertSort(int[] arr) {
        for (int i=1;i<arr.length;i++) {
            int key = arr[i];
            int j=i-1;
            /* Move elements of arr[0...i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j] > key) {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
}
