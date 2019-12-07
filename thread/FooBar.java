package thread;

/**
 * @ClassName FooBar
 * @Description: 交替打印FooBar
 * @Author gravel
 * @Date 2019/12/7
 * @Version V1.0
 * <p>
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 * <p>
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * 示例 2:
 * <p>
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-foobar-alternately
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    private volatile boolean isFoo = true;

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                if (!isFoo) this.wait();
                printFoo.run();
                isFoo = false;
                this.notifyAll();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                if (isFoo) this.wait();
                printBar.run();
                isFoo = true;
                this.notifyAll();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar fb = new FooBar(2);
        new Thread(() -> {
            try {
                fb.bar(() -> {
                    System.out.print("bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fb.foo(() -> {
                    System.out.print("foo");

                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }
}
