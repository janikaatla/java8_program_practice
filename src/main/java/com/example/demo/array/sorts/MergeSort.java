package com.example.demo.array.sorts;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5,4,2,3};
        int n = arr.length;

        mergeSort(arr, 0, n - 1);

        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m=(l+r) / 2;
            System.out.println("l:"+l+"m:"+m+"r:"+r);
            mergeSort(arr, l,m);
            mergeSort(arr, m+1,r);
            System.out.println("l:"+l+"m:"+m+"r:"+r);
            merge(arr,l,m,r);
        }


    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1=m-l+1;
        int n2=r - m;

        System.out.println("l:"+l+"m:"+m+"r:"+r+"======n1:"+n1+"n2:" + n2);

        // temp sub arrays
        int[] L=new int[n1];
        int[] R=new int[n2];

        int i=0,j=0,k=l;
        while(i < n1) {
            L[i]=arr[l+i];
            i++;
        }

        while(j < n2) {
            R[j]=arr[m+1+j];
            j++;
        }

        i=0;j=0;

        while(i<n1 && j<n2) {
            if (L[i] <= R[j]) {
                arr[k++]=L[i++];
            } else {
                arr[k++]=R[j++];
            }
        }

        while(i<n1) {
                arr[k++]=L[i++];

        }

        while(j<n2) {
                arr[k++]=R[j++];
        }
    }


}
