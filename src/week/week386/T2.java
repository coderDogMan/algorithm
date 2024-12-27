package week.week386;

public class T2 {

    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long bottomX = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                long bottomY = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                long topX = Math.min(topRight[i][0], topRight[j][0]);
                long topY = Math.min(topRight[i][1], topRight[j][1]);
                if (bottomX >= topX || bottomY >= topY) continue;
                if (topX - bottomX == topY - bottomY) {
                    ans = Math.max(ans, (topX - bottomX) * topX - bottomX);
                }
            }
        }
        return ans;
    }
}


class Test5 {
    public static void main(String[] args) {
        T2 t2 = new T2();
        t2.largestSquareArea(new int[][]{{2,2},{3,1}}, new int[][]{{5,5}, {5,5}});

    }
}