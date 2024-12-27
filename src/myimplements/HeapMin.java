package myimplements;

public class HeapMin {
    public void heapify(int[] arr, int n, int i) {
        int min = i;
        int leftSon = i * 2 + 1;
        int rightSon = i * 2 + 2;
        if (leftSon < n && arr[leftSon] < arr[min])
            min = leftSon;
        if (rightSon < n && arr[rightSon] < arr[min])
            min = rightSon;
        if (min != i) {
            swap(arr, i, min);
            heapify(arr, n, min);
        }
    }
    public void heapSort(int[] arr, int n) {

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }

    }

    public void swap(int[] arr, int i, int min) {
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }
}
