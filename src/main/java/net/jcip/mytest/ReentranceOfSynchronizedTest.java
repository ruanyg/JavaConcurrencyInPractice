package net.jcip.mytest;

/**
 * Created by ruanyg on 16/9/14.
 */
public class ReentranceOfSynchronizedTest {
    private synchronized void f1() {
        System.out.println("f1 called!");
    }

    public synchronized void f2() {
        System.out.println("f2 called!");
        f1();
    }

    public static void main(String[] args) {
        ReentranceOfSynchronizedTest test = new ReentranceOfSynchronizedTest();
        test.f2();
    }
}
