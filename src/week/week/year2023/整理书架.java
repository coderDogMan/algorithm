package week.week.year2023;

import java.util.HashMap;
import java.util.LinkedList;

public class 整理书架 {
    public int[] arrangeBookshelf(int[] order, int limit) {
        HashMap<Integer, Integer> outMap = new HashMap<>();
        HashMap<Integer, Integer> inMap = new HashMap<>();
        int n = order.length;
        for (int key : order) {

            outMap.put(key, outMap.getOrDefault(key, 0) + 1);
        }
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int key = order[i];
            inMap.put(key, inMap.getOrDefault(key, 0) + 1);
            outMap.put(key, outMap.getOrDefault(key, 0) - 1);

            if (stack.isEmpty() || stack.getLast() <= order[i] && inMap.get(key) + outMap.get(key) <= limit) {
                stack.add(order[i]);
            } else {
                while (!stack.isEmpty() && stack.getLast() <= order[i] && inMap.get(stack.getLast()) + outMap.get(stack.getLast()) > limit) {
                    inMap.put(stack.getLast(), inMap.getOrDefault(stack.getLast(), 0) - 1);
                    stack.poll();
                }
                stack.add(order[i]);
            }
        }

        int[] ans = stack.stream().mapToInt(Integer::intValue).toArray();
        return ans;

    }
}

class Test42 {
    public static void main(String[] args) {
        整理书架 test = new 整理书架();
        test.arrangeBookshelf(new int[]{3,3,9,8,9,2,8}, 1);
//        test.arrangeBookshelf(new int[]{5,5,6,5}, 3);
//        test.arrangeBookshelf(new int[]{5,5,6,5}, 2);
    }
}