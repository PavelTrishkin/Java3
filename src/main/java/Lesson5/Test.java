package Lesson5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Test {
    public static void main(String[] args) {
        final CountDownLatch cdl = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            final int w = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(300 * w);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("стартуем");

                    cdl.countDown();

                    try {
                        cdl.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("продолжаем работу");

                }
            }).start();
        }


//        final CyclicBarrier cbb = new CyclicBarrier(10);
//
//        for (int i = 1; i < 5; i++) {
//            final int w = i;
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(w + " start");
//
//                    try {
//                        Thread.sleep((int) Math.random() * 3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(w + " ready");
//
//                    try {
//                        cbb.await();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } catch (BrokenBarrierException e) {
//                        e.printStackTrace();
//                    }
//
//                    System.out.println("работа потока после остановки " + Thread.currentThread().getName());
//                }
//            }).start();
//        }
    }
}
