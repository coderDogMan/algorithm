package other.hard;

import java.util.*;
import java.util.stream.IntStream;

public class 花期内花的数目2251 {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] flower : flowers) {
            map.put(flower[0], map.getOrDefault(flower[0], 0) + 1);
            map.put(flower[1] + 1, map.getOrDefault(flower[1] + 1, 0) - 1);
        }
        int[] keys = map.keySet().stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(keys);
//        Arrays.sort(persons);
        int n = persons.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++)
            ids[i] = i;
//        Integer[] ids = IntStream.range(0, persons.length).boxed().toArray(Integer[]::new);
        Arrays.sort(ids, (i, j) -> (persons[i] - persons[j]));

        int[] ans = new int[persons.length];
        int i = 0;
        int sum = 0;
        for (Integer id : ids) {
            while (i < keys.length && keys[i] <= persons[id]) {
                sum += map.get(keys[i++]);
            }
            ans[id] = sum;
        }
        return ans;
    }
}

class Test3 {
    public static void main(String[] args) {
        花期内花的数目2251 test = new 花期内花的数目2251();
//        test.fullBloomFlowers(new int[][]{
//                {1,6},{3,7},{9,12},{4,13},
//        }, new int[]{2,3,7,11});
        test.fullBloomFlowers(new int[][]{{1,10}, {3,3}}, new int[]{3,3,2});
    }
}
