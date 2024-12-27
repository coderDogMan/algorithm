package week.week345;

public class T2 {
    public boolean doesValidArrayExist(int[] derived) {
        int ans = 0;
        for (int i = 0; i < derived.length; i++) {
            ans ^= derived[i];
        }
        return ans == 0;
    }
}


class Test2 {
    public static void main(String[] args) {
        T2 test = new T2();
        test.doesValidArrayExist(new int[]{1,1,0});
    }
}

