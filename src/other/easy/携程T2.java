package other.easy;


class T2 {

    String s;
    public T2(String s) {
        this.s = s;
    }
    public String reWrite( int p, int q) {
        int n = q - p + 1;
        StringBuilder builder = new StringBuilder(s);
        int i = p - 1;
        while (n-- > 0) {
            builder.insert(i, builder.charAt(i) + "");
            i += 2;
        }
        s = builder.toString();
        return s;
    }
}


public class 携程T2 {
    public static void main(String[] args) {
        T2 t2 = new T2("abcdef");
        System.out.println(t2.reWrite( 2, 4));
        System.out.println(t2.reWrite( 3, 6));

    }
}
