package writtentest.meituan2023;


import java.util.Arrays;
import java.util.Scanner;

public class 塔子哥的众数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            sum += nums[i];
        }
        if (sum % n == 0) {
            long ans = 0;
            long avg = sum / n;
            for (int i = 0; i < n; i++) {
                ans += Math.abs(avg - nums[i]);
            }
            System.out.println(ans / 2);
            return;
        } else {
            Arrays.sort(nums);
            long post1 = 0;
            long neg1 = 0;

            long post2 = 0;
            long neg2 = 0;
            // 去除最小的
            long ceilStart = (long) Math.ceil(sum - nums[0] / n);
            long floorStart = (long) Math.floor(sum - nums[0] / n);
            for (int i = 1; i < n; i++) {
                if (nums[i] < ceilStart) {
                    post1 += ceilStart - nums[i];
                } else if (nums[i] > ceilStart) {
                    neg1 += nums[i] - ceilStart;
                }
                if (nums[i] < floorStart) {
                    post2 += floorStart - nums[i];
                } else if (nums[i] > floorStart) {
                    neg2 += nums[i] - floorStart;
                }
            }


            long post3 = 0;
            long neg3 = 0;

            long post4 = 0;
            long neg4 = 0;
            //去除最大的
            long ceilEnd = (long) Math.ceil(sum - nums[n - 1] / n);
            long floorEnd = (long) Math.floor(sum - nums[n - 1] / n);
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] < ceilEnd) {
                    post3 += ceilEnd - nums[i];
                } else if (nums[i] > ceilEnd) {
                    neg3 += nums[i] - ceilEnd;
                }
                if (nums[i] < floorEnd) {
                    post4 += floorEnd - nums[i];
                } else if (nums[i] > floorEnd) {
                    neg4 += nums[i] - floorStart;
                }
            }
            System.out.println(Math.min(Math.min(Math.max(post1, neg1), Math.max(post2, neg2)), Math.min(Math.max(post3, neg3), Math.max(post4, neg4))));
        }

    }
}
