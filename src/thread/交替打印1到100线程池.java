package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 交替打印1到100线程池 {
    static volatile int num = 1;
    static Object lock = new Object();
    public static void main(String[] args) {

        Test1 test1 = new Test1();
        Test2 test2 = new Test2();
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.execute(test1);
        threadPool.execute(test2);


    }

    static class Test1 implements Runnable {
        @Override
        public void run() {
            while (num < 100) {
                synchronized (lock) {
                    while (num % 2 == 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + num++);
                    lock.notifyAll();
                }
            }
        }
    }

    static class Test2 implements Runnable {
        @Override
        public void run() {
            while (num < 100) {
                synchronized (lock) {
                    while (num % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName()  + num++);
                    lock.notifyAll();
                }
            }
        }
    }


}
