package thread;


public class 交替打印1到100 {
    static volatile int num = 1;
    static Object lock = new Object();
    public static void main(String[] args) {

        new Thread(() -> {
            while (num <= 100) {
                synchronized (lock) {
                    while (num % 2 == 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " :" + num++);
                    lock.notifyAll();
                }
            }
        }).start();

        new Thread(() -> {
            while (num <= 100) {
                synchronized (lock) {
                    while (num % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " :" + num++);
                    lock.notifyAll();
                }
            }
        }).start();

    }


}
