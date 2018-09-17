package com.learn.ThreadStop;

import java.util.concurrent.TimeUnit;

/**
 * author:liman
 * createtime:2018/9/17
 * mobile:15528212893
 * email:657271181@qq.com
 * comment:
 *      interrupt异常会清空标志位
 */
public class InterruptExceptionDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
           while(true){
               try {
                   System.out.println(Thread.currentThread().isInterrupted());
                   Thread.sleep(2000);
               } catch (InterruptedException e) {
                   //InterruptedException的抛出异常操作，会清空interrupt标志位
                   e.printStackTrace();
               }
           }
        });

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        System.out.println(thread.isInterrupted());
        TimeUnit.SECONDS.sleep(1);
        System.out.println(thread.isInterrupted());
    }
}