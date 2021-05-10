package PrintInOrder;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Foo {

    AtomicInteger firstjobDone = new AtomicInteger(0);
    AtomicInteger secondjobDone = new AtomicInteger(0);
    //private final Semaphore firstSemaphore = new Semaphore(0);
    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {


        printFirst.run();
        firstjobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while(firstjobDone.get() != 1) {}
        printSecond.run();
        secondjobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while(secondjobDone.get() != 1){}
        printThird.run();
    }
}
