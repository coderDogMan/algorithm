package other.mid;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class 前K个高频元素347 {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((arr1, arr2) -> (arr1.getValue() - arr2.getValue()));
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entrys = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrys) {
            queue.add(entry);
            if (queue.size() > k)
                queue.poll();
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll().getKey();
        }
        return ans;
    }
}

