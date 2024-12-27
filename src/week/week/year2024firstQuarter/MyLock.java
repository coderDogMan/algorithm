package week.week.year2024firstQuarter;

import com.sun.jdi.ThreadReference;

import java.util.concurrent.atomic.AtomicReference;

public class MyLock {
    AtomicReference<Thread> owner = new AtomicReference<>();

    public void lock() {
        Thread thread = Thread.currentThread();
        while (!owner.compareAndSet(null, thread)) {
            System.out.println("CAS");
        }
    }

    public void unLock() {
        Thread thread = Thread.currentThread();
        owner.set(null);
    }

}
