package com.example.demo.arrays.logics;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindClosestNumFromUnSortedArrayByMap {
    public static void main(String[] args) {
        int[] arr = { -10, -50, 23, 17, 80 };
        int X = 20, K = 2;
        int N = arr.length;

        printClosest(arr, N, X);
    }

    public static void printClosest(int[] arr, int n, int x) {
        // Make a max heap.
        LinkedHashMap<Integer, Integer> pq=new LinkedHashMap<>(1);
        pq.put(arr[0], Math.abs(arr[0] - x));
        for (int i = 1; i < n; i++) {
            int diff = Math.abs(arr[i] - x);

            // If difference with current element is more than root, then ignore it.
            Map.Entry<Integer, Integer> entry = pq.entrySet().iterator().next();
            if (diff > entry.getValue()) {
                continue;
            }

            // Else remove root and insert
            pq.remove(entry.getKey(), entry.getValue());
            pq.put(arr[i], diff);
        }

        // Print contents of heap.
        if (!pq.isEmpty()) {
            // System.out.print(pq.poll().getKey() + " ");
            Iterator<Map.Entry<Integer,Integer>> it=pq.entrySet().iterator();
            while (it.hasNext()) {
                System.out.print(it.next().getKey() + " ");
            }
        }
    }
}
