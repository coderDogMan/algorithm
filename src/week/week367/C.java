package week.week367;

import java.util.PriorityQueue;

public class C {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;
        int max = 0;
        int min = 0;
        int l = -1;
        int r = -1;
        for (int i = indexDifference; i < n; i++) {

            if (nums[i - indexDifference] < nums[min]) {
                min = i - indexDifference;
            }
            if (nums[i - indexDifference] > nums[max]) {
                max = i - indexDifference;
            }

            if (Math.abs(nums[i] - nums[max]) >= valueDifference) {
                l = max;
                r = i;
            }
            if (Math.abs(nums[i] - nums[min]) >= valueDifference) {
                l = min;
                r = i;
            }

        }
        return new int[]{l, r};

    }
}
class Test {
    public static void main(String[] args) {
        C c = new C();
        int[] indices2 = c.findIndices(new int[]{7,6,3,5,9,5}, 2, 6);
        System.out.println(indices2);

    }
}
