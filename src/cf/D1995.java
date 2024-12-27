package cf;

import java.util.Scanner;

public class D1995 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[(int) ((1e6) + 1)];
            for (int i = 0; i < n; i++) a[i] = in.nextInt();
            for (int i = 0; i < m; i++) b[in.nextInt()]++;
            int ans = 0;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                if (b[a[i]] > 0) cnt++;
                b[a[i]]--;
            }
            if (cnt >= k) ans++;
            for (int i = m; i < n; i++) {
                if (b[a[i]] > 0) cnt++;
                b[a[i]]--;
                if (b[a[i - m]] >= 0) cnt--;
                b[a[i - m]]++;
                if (cnt >= k) ans++;
            }
            System.out.println(ans);
        }
    }
}

class PrintNumberAlternately {
    public static void main(String[] args) {
        final Printer printer = new Printer();

        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 10; i += 3) {
                try {
                    printer.print(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 2; i <= 10; i += 3) {
                try {
                    printer.print(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 3; i <= 10; i += 3) {
                try {
                    printer.print(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Printer {
    private int num = 1;
    private final Object lock = new Object();

    public void print(int currentNum) throws InterruptedException {
        synchronized (lock) {
            while (num!= currentNum) {
                lock.wait();
            }
            System.out.println(Thread.currentThread().getName() + " 打印数字: " + num);
            num++;
            lock.notifyAll();
        }
    }
}