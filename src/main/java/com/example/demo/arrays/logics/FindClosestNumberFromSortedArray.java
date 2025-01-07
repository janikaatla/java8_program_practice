package com.example.demo.arrays.logics;

public class FindClosestNumberFromSortedArray {
    public static void main(String[] arg) {
        int[] arr = { 1, 2,2, 4, 5, 6, 6, 6,6,6, 7,9, 11 };
        // int n = arr.length;
        int target = 8;
        System.out.println(findClosestWithLogNComplexity(arr, target));
        System.out.println(findClosestWithNComplexity(arr, target));
    }

    // Time Complexity is O(lon(n))
    public static int findClosestWithLogNComplexity(int[] arr, int target) {
        int n = arr.length;

        // Corner cases
        if (target <= arr[0]) {
            return arr[0];
        }
        if (target >= arr[n - 1]) {
            return arr[n - 1];
        }

        // Doing binary search
        int i = 0, j = n, mid = 0;
        while (i < j) {
            mid = (i + j) / 2; // if it values 4.5, always gives less value as 4
            System.out.println("mid val : "+ mid);

            /* If target is equal than mid val, return mid val */
            if (arr[mid] == target) { // first time is 6 comes next iteration values 4
                return arr[mid];
            }

            /* If target is less than mid val, then search in left */
            if (target < arr[mid]) {
                /* If target is greater than previous to mid, return closest of two */
                if (mid > 0 && target > arr[mid - 1]) {
                    System.out.println("If target is greater than previous to mid, return closest of two");
                    return getClosest(arr[mid - 1],
                            arr[mid], target);
                }
                /* Repeat for left half */
                j = mid;
            }
            /* If target is greater than mid */
            else {
                /* If target is less than next to mid, return closest of two */
                if (mid < n-1 && target < arr[mid + 1]) {
                    System.out.println("If target is less than next to mid, return closest of two");
                    return getClosest(arr[mid],
                            arr[mid + 1], target);
                }
                /* Repeat for right half */
                i = mid + 1;
            }
        }
        /* Only single element left after search */
        return arr[mid];
    }

    // Method to compare which one is the more close
    // We find the closest by
    private static int getClosest(int lessVal, int highVal, int target) {
        if (target - lessVal > highVal - target) {
            return highVal;
        } else {
            return lessVal;
        }
    }

    public static int findClosestWithNComplexity(int[] arr, int target) {
        int n=arr.length;
        int left = 0, right = n - 1;
        while (left < right) {
            if (findDiff(arr[left] - target)
                    <= findDiff(arr[right] - target)) {
                right--;
            }
            else {
                left++;
            }
        }
        return arr[left];
    }

    private static int findDiff(int diff) {
        return diff < 0? -diff: diff;
    }
}
