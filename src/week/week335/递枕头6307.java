package week.week335;

public class 递枕头6307 {
    // 9 4
    // 2 4
    public int passThePillow(int n, int time) {
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++)
            arr[i - 1] = i;
        int index = 0;
        boolean flag = false;
        while (time-- > 0) {
            if (!flag && index < n - 1) {
                index++;
            } else if (flag && index > 0){
                index--;
            } else if (!flag && index == n - 1) {
                index--;
                flag = !flag;
            } else if (flag && index == 0) {
                index++;
                flag = !flag;
            }
        }
        return arr[index];
    }
}

class Test {
    public static void main(String[] args) {
        递枕头6307 test = new 递枕头6307();
        System.out.println(test.passThePillow(9, 4));
        System.out.println(test.passThePillow(3, 2));
        System.out.println(test.passThePillow(2, 2));

    }
}