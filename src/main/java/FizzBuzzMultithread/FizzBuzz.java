package FizzBuzzMultithread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private final int n;
    private final AtomicInteger current = new AtomicInteger(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (current) {
            while(current.get() <= n){
                if(current.get() % 3 != 0 || current.get() % 5 == 0){
                    current.wait();
                    continue;
                }
                printFizz.run();
                current.getAndIncrement();
                current.notifyAll();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (current){
            while(current.get() <= n){
                if(current.get() % 3 != 0 || current.get() % 5 == 0){
                    current.wait();
                    continue;
                }
                printBuzz.run();
                current.getAndIncrement();
                current.notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (current){
            while(current.get() <= n){
                if(current.get() % 15 != 0){
                    current.wait();
                    continue;
                }
                printFizzBuzz.run();
                current.getAndIncrement();
                current.notifyAll();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (current){
            while(current.get() <= n){
                if(current.get() % 3 == 0 || current.get() % 5 == 0){
                    current.wait();
                    continue;
                }
                printNumber.accept(current.get());
                System.out.println(current);
                current.getAndIncrement();
                current.notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        Runnable printFizz = () -> {
            System.out.println("fizz");
        };
        Runnable printBuzz = () -> {
            System.out.println("buzz");
        };
        Runnable printFizzBuzz = () -> {
            System.out.println("fizzbuzz");
        };
        IntConsumer intConsumer = value -> value = 1;
        Thread t1 = new Thread(() -> {
            try {
                fizzBuzz.fizz(printFizz);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                fizzBuzz.buzz(printBuzz);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(printFizzBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t4 = new Thread(() -> {
            try {
                fizzBuzz.number(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }
}
