package PrintZeroEvenOdd;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * Given n = 4
 * guarantee Print 0 1 0 2 0 3 0 4
 */

public class ZeroEvenOdd {
    //If we use latches, we have to create n latches
    //instead we can use Semaphores
    private int n;
    private int lastPrinted;

    private Semaphore zeroSem;
    private Semaphore oddSem;
    private Semaphore evenSem;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.lastPrinted = 0;
        this.zeroSem = new Semaphore(1);
        this.oddSem  = new Semaphore(1);
        this.evenSem = new Semaphore(1);

        try{
            this.evenSem.acquire();
            this.oddSem.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        int numZeroes = n;
        while(numZeroes -- > 0){
            zeroSem.acquire();
            printNumber.accept(0);

            if(lastPrinted % 2 == 0){
                oddSem.release();
            } else{
                evenSem.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        int numEven = n/2;
        while(numEven-- > 0) {
            evenSem.acquire();
            printNumber.accept(++lastPrinted);
            zeroSem.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int numOdd = n - n/2;
        while(numOdd-- > 0) {
            oddSem.acquire();
            printNumber.accept(++lastPrinted);
            zeroSem.release();
        }
    }
}
