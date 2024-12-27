package other.mid;

import other.easy.K次取反后最大化的数组和1005;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class 根据身高重建队列406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (arr1, arr2) -> {
            if (arr1[0] == arr2[0]) return arr1[1] - arr2[1];
            return arr2[0] - arr1[0];
        });
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }

        return list.toArray(new int[people.length][2]);
    }
}

