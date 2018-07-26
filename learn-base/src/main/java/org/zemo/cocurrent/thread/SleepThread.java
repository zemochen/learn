package org.zemo.cocurrent.thread;

/**
 * @ClassName: SleepThread
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 18/05/2017 16:25
 * @Description 探讨sleep 和wait 对锁机制的影响
 */
public class SleepThread implements Runnable {
    int number = 10;

    public void firstMethod() throws Exception {
        synchronized (this) {
            System.out.println("first thread-" + Thread.currentThread().getName());

            /*
             * sleep 不会释放锁，依然持有锁
             * wait 会释放锁，让出资源
             */
            Thread.sleep(2000);
//            this.wait(2000);
            number += 100;
            System.out.println("first:" + number);
        }
    }

    public void secondMethod() throws Exception {
        synchronized (this) {
            System.out.println("second thread-" + Thread.currentThread().getName());
            number *= 200;
        }
    }

    public void run() {
        try {
            firstMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SleepThread threadTest = new SleepThread();
        Thread thread = new Thread(threadTest);
        thread.start();
        try {
            //确保先执行线程中的代码
            Thread.sleep(500);

            threadTest.secondMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Test {
    //main方法在线程类中无法保证主线程绝对优先执行
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("----------------" + i + " time-------------");
            SleepThread threadTest = new SleepThread();
            Thread thread = new Thread(threadTest);
            thread.start();
            try {
                //确保先执行线程中的代码
//                Thread.sleep(500);

                threadTest.secondMethod();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("last:" + threadTest.number);
        }

    }
}

