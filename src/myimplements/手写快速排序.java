package myimplements;

import java.util.Arrays;

public class 手写快速排序   {
    public static void main(String[] args) {
        int arr[] = {5,3,56,2,5,7,2,7,688,12,3,7,7};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int pivot = arr[start];
        int left  = start;
        int right  = end;
        while (left < right) {
            while (left < right && arr[right] >= pivot) --right;
            while (left < right && arr[left] <= pivot) ++left;
            if (left < right) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }
        arr[start] = arr[left];
        arr[left] = pivot;
        quickSort(arr,start, left - 1);
        quickSort(arr, left + 1, end);
    }
}
