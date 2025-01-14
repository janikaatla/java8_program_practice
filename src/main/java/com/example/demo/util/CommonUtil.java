package com.example.demo.util;

public final class CommonUtil {
    public static int findDiff(int diff) {
        return diff < 0? -diff: diff;
    }

    public static Pair<Integer, Integer> getMidValueFromUnArray(int[] arr, int low, int high) {
        int maxVal, minVal, averageVal,
                nearestDiff, l, nextDiff, sum;
        maxVal=minVal=sum=arr[low];
        Pair<Integer,Integer> valIndexPair = new Pair(arr[low],low);
        for (int i=low+1;i<high;) {
            l=arr[i++];
            sum+=l;
            if (maxVal < l) {
                maxVal=l;
            }
            if (minVal>l) {
                minVal=l;
            }
        }
        averageVal = (sum) / (high-low);
        nearestDiff = findDiff(averageVal - valIndexPair.getKey());
        for (int i=low+1;i<high;i++) {
            l=arr[i];
            nextDiff=findDiff(averageVal - l);
            if (nearestDiff > nextDiff) {
                nearestDiff=nextDiff;
                valIndexPair.setKey(l);
                valIndexPair.setValue(i);
            }
        }
        return valIndexPair;
    }

    public static Pair<Integer, Integer> getMidPositionValueFromUnArray(int[] arr, int low, int high) {
        int maxVal, minVal, averageVal,
                nearestDiff, l, nextDiff, sum;
        maxVal=minVal=sum=arr[low];
        Pair<Integer,Integer> valIndexPair = new Pair(arr[low],low);
        for (int i=low+1;i<high;) {
            l=arr[i++];
            sum+=l;
            if (maxVal < l) {
                maxVal=l;
            }
            if (minVal>l) {
                minVal=l;
            }
        }
        averageVal = (sum) / (high-low);
        nearestDiff = findDiff(averageVal - valIndexPair.getKey());
        for (int i=low+1;i<high;i++) {
            l=arr[i];
            nextDiff=findDiff(averageVal - l);
            if (nearestDiff > nextDiff) {
                nearestDiff=nextDiff;
                valIndexPair.setKey(l);
                valIndexPair.setValue(i);
            }
        }
        return valIndexPair;
    }

    public static void swap(int[] arr, int firstIndex, int nextIndex) {
        int temp=arr[firstIndex];
        arr[firstIndex]=arr[nextIndex];
        arr[nextIndex]=temp;
    }
}
