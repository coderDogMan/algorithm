package week.week391;


public class T4 {

    int[][] node = new int[][] {{0, 0}, {0, (int) 1e8}, {(int) 1e8, 0}, {(int) 1e8, (int) 1e8}};
    public int minimumDistance(int[][] points) {
        int n = points.length;
        int[] LD = new int[2], LU = new int[2], RD = new int[2], RU = new int[2];
        int LDL = Integer.MAX_VALUE, LUL = Integer.MAX_VALUE, RDL = Integer.MAX_VALUE, RUL = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int[] cur = points[i];
            if (Math.abs(cur[0] - node[0][0]) + Math.abs(cur[1] - node[0][1]) < LDL) {
                LDL = Math.abs(cur[0] - node[0][0]) + Math.abs(cur[1] - node[0][1]);
                LD = cur;
            }
            if (Math.abs(cur[0] - node[1][0]) + Math.abs(cur[1] - node[1][1]) < LUL) {
                LUL = Math.abs(cur[0] - node[1][0]) + Math.abs(cur[1] - node[1][1]);
                LU = cur;
            }
            if (Math.abs(cur[0] - node[2][0]) + Math.abs(cur[1] - node[2][1]) < RDL) {
                RDL = Math.abs(cur[0] - node[2][0]) + Math.abs(cur[1] - node[2][1]);
                RD = cur;
            }
            if (Math.abs(cur[0] - node[3][0]) + Math.abs(cur[1] - node[3][1]) < RUL) {
                RUL = Math.abs(cur[0] - node[3][0]) + Math.abs(cur[1] - node[3][1]);
                RU = cur;
            }
        }
        int[] LDT = getTwo(points, node[0], LD);
        int[] LUT = getTwo(points, node[1], LU);
        int[] RDT = getTwo(points, node[2], RD);
        int[] RUT = getTwo(points, node[3], RU);
        int[][] nums1 = {LDT, LU, RD, RU};
        int[][] nums2 = {LD, LUT, RD, RU};
        int[][] nums3 = {LD, LU, RDT, RU};
        int[][] nums4 = {LD, LU, RD, RUT};
        int res1 = getMin(nums1);
        int res2 = getMin(nums2);
        int res3 = getMin(nums3);
        int res4 = getMin(nums4);
        return Math.min(Math.min(res1, res2), Math.min(res3, res4));
    }

    private int getMin(int[][] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                int l = Math.abs(nums[i][0] - nums[j][0]) + Math.abs(nums[i][1] - nums[j][1]);
                if (l > max) {
                    max = l;
                }
            }
        }
        return max;
    }

    private int[] getTwo(int[][] points, int[] max, int[] exl) {
        int m = Integer.MAX_VALUE;
        int[] res = new int[2];
        for (int i = 0; i < points.length; i++) {
            int[] cur = points[i];
            if (Math.abs(cur[0] - max[0]) + Math.abs(cur[1] - max[1]) < m && (cur != exl)) {
                m = Math.abs(cur[0] - max[0]) + Math.abs(cur[1] - max[0]);
                res = cur;
            }
        }
        return res;
    }
}

class Test4 {
    public static void main(String[] args) {
        T4 t4 = new T4();
//        t4.minimumDistance(new int[][]{{4,4},{4,8},{8,4},{8,8}});
//        t4.minimumDistance(new int[][]{{3,10},{5,15},{10,2},{4,4}});
        t4.minimumDistance(new int[][]{{1,1},{1,1},{1,1}});
    }
}
