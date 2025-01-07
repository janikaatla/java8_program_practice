package com.example.demo.arrays.logics;

import com.example.demo.util.CommonUtil;
import com.example.demo.util.Pair;

public class FindClosestNumFromUnSortedArray {
    public static void main(String[] args) {
        int[] arr = { -10, -50, 23, 17, 80 };
        int X = 20, K = 2;
        int N = arr.length;

        printClosest(arr, N, X);
    }

    public static void printClosest(int[] arr, int n, int x) {
        // Make a max heap.
        Pair<Integer, Integer> pq=new Pair<>(arr[0], CommonUtil.findDiff(arr[0] - x));
        for (int i = 1; i < n; i++) {
            int diff = CommonUtil.findDiff(arr[i] - x);

            // If difference with current element is more than root, then ignore it.
            if (diff > pq.getValue()) {
                continue;
            }

            // Else remove root and insert
            pq.setKey(arr[i]);
            pq.setValue(diff);
        }
        // Print contents of heap.
        System.out.print(pq.getKey() + " ");
    }
}
