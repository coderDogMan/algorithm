package week.week379;

import writtentest.huawei2023.分配资源ID;

public class T2 {

    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
       if ( a == e && (c != a || !check(b, d, f)) ||
            b == f && (d != f || !check(a, c, e)) ||
            c + d == e + f && (a + b != e + f || check(c, a, e)) ||
            c - d == e - f && (a - b != e - f || check(c, a, e))
       ) return 1;
       return 2;
    }

    private boolean check(int l, int mid, int r) {
        return Math.min(l, r) < mid && mid < Math.max(l, r);
    }

}

class Test2 {
    public static void main(String[] args) {
        T2 t2 = new T2();
        t2.minMovesToCaptureTheQueen(2,
                4,
                2,
                8,
                8,
                2);
    }
}