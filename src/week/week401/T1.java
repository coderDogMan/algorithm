package week.week401;

/**
 * @Author: min
 * @Date:
 */
public class T1 {

    public int numberOfChild(int n, int k) {
        k = k % ((n - 1) * 2);
        if (k > (n - 1)) return (n - 1) - (k % (n - 1));
        else return k;
    }
}

class Test1 {
    public static void main(String[] args) {
        T1 t1 = new T1();
//        System.out.println(t1.numberOfChild(3, 3));
        System.out.println(t1.numberOfChild(3, 5));
        System.out.println(t1.numberOfChild(5, 6));
        System.out.println(t1.numberOfChild(4, 2));
    }
}
