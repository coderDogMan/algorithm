package myimplements;

import other.mid.数组中的第K个最大元素215;

import java.util.Scanner;

public class HeapMax {

    public void heapify(int[] arr, int n, int i) {
        int largest = i;
        int leftSon = 2 * i + 1;
        int rightSon = 2 * i + 2;
        if (leftSon < n && arr[largest] < arr[leftSon])
            largest = leftSon;
        if (rightSon < n && arr[largest] < arr[rightSon])
            largest = rightSon;
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    public void heapSort(int[] arr, int n) {
        //create
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        //
        for (int i = n - 1; i > 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    private void swap(int[] arr, int i, int largest) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
    }
}


