package com.company;

import java.util.concurrent.CountDownLatch;

/**
 * @author lyy
 * @date 2020/4/1 12:09 上午
 */
public class VoTest {

    private static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {


        System.out.println("11111");
        System.out.println("11111");
        System.out.println("22222");
        System.out.println("我要这个");
        System.out.println("我要这个1111");
        System.out.println("我要这个2222");
        System.out.println("主线程开始工作");
        System.out.println("temp=1111111");
        System.out.println("44444");
        new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程1完成任务");
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2完成任务");
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程3完成任务");
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        Thread.currentThread().join();
        System.out.println("全部完成任务，主线程继续执行。。。");


        System.out.println("5555");
        System.out.println("11111111111");

    }

}
