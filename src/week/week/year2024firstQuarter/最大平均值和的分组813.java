package week.week.year2024firstQuarter;

public class 最大平均值和的分组813 {
    public double largestSumOfAverages(int[] nums, int k) {
        // n 个数 划分 k段 平均值的sum
        // f[k][n] = f[k - 1][n - 1] + nums[n]
        // f[k][n] = f[k - 1][n - 2] + (nums[n] + nums[n - 1]) / 2;
        // f[k][n] = f[k - 1][n - 3] + (nums[n] + nums[n - 1] + nums[n - 2]) / 3;
        // f[k][n] = f[k - 1][n - L] + (num[])
        int n = nums.length;
        double[][] f = new double[n + 1][k + 1];
        double[] sum = new double[n + 1];
        for (int i = 0; i < n; i++) sum[i + 1] = sum[i] + nums[i];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j == 1) {
                    f[i][1] = sum[i] / i;
                } else {
                    for (int l = 2; l <= i; l++)
                        f[i][j] = Math.max(f[i][j], f[i - l][j - 1] + (sum[i] - sum[i - l]) / l);
                }
            }
        }
        return f[n][k];

    }
}

class Test10 {
    public static void main(String[] args) {
        最大平均值和的分组813 test = new 最大平均值和的分组813();
        test.largestSumOfAverages(new int[]{1,2,3,4,5,6,7}, 4);
//        test.largestSumOfAverages(new int[]{9,1,2,3,9}, 3);
    }
}
