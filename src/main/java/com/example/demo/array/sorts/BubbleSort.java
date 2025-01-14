package com.example.demo.array.sorts;

public class BubbleSort {
    public static void main(String[] args){
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        int n = arr.length;
        bubbleSort(arr, n);
        System.out.println("Sorted array: ");
        printArray(arr, n);
    }

    static void printArray(int[] arr, int size){
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private static void bubbleSort(int[] arr, int n) {
        int temp; boolean swapped;
        for (int i=0;i< n-1; i++) {
            swapped=false;
            for (int j=i+1;j<n;j++) {
                if (arr[i] > arr[j]) {
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                    swapped=true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
