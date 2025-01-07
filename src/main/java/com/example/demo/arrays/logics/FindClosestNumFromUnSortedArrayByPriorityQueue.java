package com.example.demo.arrays.logics;

import java.util.*;

public class FindClosestNumFromUnSortedArrayByPriorityQueue {

    // Driver code
    public static void main(String[] args) {
        int[] arr = { -10, -50, 23, 17, 80 };
        int X = 20, K = 2;
        int N = arr.length;

        new FindClosestNumFromUnSortedArrayByPriorityQueue().printClosest(arr, N, X);
    }

    public void printClosest(int[] arr, int n,
                                     int x) {
        // Make a max heap.
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.getValue().compareTo(
                p1.getValue()));
        pq.offer(new Pair(arr[0], findDiff(arr[0] - x)));
        for (int i = 1; i < n; i++) {
            int diff = findDiff(arr[i] - x);
            // If difference with current element is more than root, then ignore it.
            assert pq.peek() != null;
            if (diff > pq.peek().getValue()) {
                continue;
            }

            // Else remove root and insert
            pq.poll();
            pq.offer(new Pair(arr[i], diff));
        }

        // Print contents of heap.
        while (!pq.isEmpty()) {
            System.out.print(pq.poll().getKey() + " ");
        }
    }

    private static int findDiff(int diff) {
        return diff < 0? -diff: diff;
    }

    static class Pair {
        Integer key;
        Integer value;

        public Pair(Integer key, Integer value)
        {
            this.key = key;
            this.value = value;
        }
        public Integer getKey() {
            return key;
        }
        public void setKey(Integer key) {
            this.key = key;
        }
        public Integer getValue() {
            return value;
        }
        public void setValue(Integer value)
        {
            this.value = value;
        }
    }

}