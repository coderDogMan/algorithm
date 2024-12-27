package writtentest.jingdei;

public class A {
    public static void main(String[] args) {
        A a1 = new B();
        A a2 = new C();
    }

    private static void get(int i) {
        try {
            i = 0 / i;
        } catch (Exception e) {
            System.out.println("get");
        } finally {
            System.out.println("get finally");
        }
    }
}
class B extends A {
    private static int a = 100;
    public static void main(String[] args) {
        B b = new B();
        b.a++;
        b = new B();
        b.a++;
        B.a++;
        System.out.println(a);
    }
}
class C extends B {
    public static void get() {
        System.out.println("11");
    }
}
