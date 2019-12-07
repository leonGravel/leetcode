package thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @ClassName FizzBuzz
 * @Description: 多线程交替打印
 * @Author gravel
 * @Date 2019/12/7
 * @Version V1.0
 *
 * 思路：
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 *
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 *
 * 假设有这么一个类：
 *
 * class FizzBuzz {
 *   public FizzBuzz(int n) { ... }               // constructor
 *   public void fizz(printFizz) { ... }          // only output "fizz"
 *   public void buzz(printBuzz) { ... }          // only output "buzz"
 *   public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
 *   public void number(printNumber) { ... }      // only output the numbers
 * }
 * 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 *
 * 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 * 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 * 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 * 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。

 **/
public class FizzBuzz {
    private int n;

    private volatile AtomicInteger cur = new AtomicInteger(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (cur.get() < n) {
            synchronized (this) {
                if (cur.get() % 3 == 0 && cur.get() % 5 != 0) {
                    printFizz.run();
                    cur.getAndAdd(1);
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (cur.get() < n) {
            synchronized (this) {
                if (cur.get() % 3 != 0 && cur.get() % 5 == 0) {
                    printBuzz.run();
                    cur.getAndAdd(1);
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (cur.get() < n) {
            synchronized (this) {
                if (cur.get() % 3 == 0 && cur.get() % 5 == 0) {
                    printFizzBuzz.run();
                    cur.getAndAdd(1);
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (cur.get() < n) {
            synchronized (this) {
                if (cur.get() % 3 != 0) {
                    if (cur.get() % 3 != 0 && cur.get() % 5 != 0) {
                        printNumber.accept(cur.get());
                        cur.getAndAdd(1);
                        this.notifyAll();
                    } else {
                        this.wait();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz(16);
        new Thread(() -> {
            try {
                fb.buzz(() -> System.out.println("buzz,"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fb.fizz(() -> System.out.println("fizz,"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fb.fizzbuzz(() -> System.out.println("fizzbuzz,"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fb.number(value -> System.out.println(value + ","));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
