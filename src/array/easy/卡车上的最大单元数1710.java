package array.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class 卡车上的最大单元数1710 {
    public static void main(String[] args) {

        int i = maximumUnits(new int[][]{{5,10}, {2, 5}, {4,7},{3,9}}, 10);
        System.out.println(i);


    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> a[1] - b[1]);
        mySort(boxTypes, 0, boxTypes.length - 1);
        int res = 0;
        for(int i = boxTypes.length - 1; i >= 0; i--) {
            if (truckSize > boxTypes[i][0]) {
                truckSize -= boxTypes[i][0];
                res += boxTypes[i][0] * boxTypes[i][1];
            } else {
                res += truckSize * boxTypes[i][1];
                break;
            }
        }
        return res;
    }

    public static void mySort(int[][] arr, int start, int end) {
        if (start >= end) return;
        int pivot = arr[start][1];
        int left = start;
        int right = end;

        while (left < right) {
            while (arr[right][1] >= pivot && left < right) right--;
            while (arr[left][1] <= pivot && left < right) left++;
            if (left < right) {
                int temp1 = arr[right][0];
                int temp2 = arr[right][1];
                arr[right][0] = arr[left][0];
                arr[right][1] = arr[left][1];
                arr[left][0] = temp1;
                arr[left][1] = temp2;
            }
        }

        int temp1 = arr[left][0];
        int temp2 = arr[left][1];
        arr[left][0] = arr[start][0];
        arr[left][1] = arr[start][1];
        arr[start][0] = temp1;
        arr[start][1] = temp2;
        mySort(arr, start, left - 1);
        mySort(arr, left + 1, end);
    }
}
