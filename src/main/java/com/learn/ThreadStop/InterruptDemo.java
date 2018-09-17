package com.learn.ThreadStop;

import java.util.concurrent.TimeUnit;

/**
 * author:liman
 * createtime:2018/9/17
 * mobile:15528212893
 * email:657271181@qq.com
 * comment:
 *      通过interrupt方法设置标志位，停止线程
 *      Thread.interrupt会重置标志位
 */
public class InterruptDemo {

    private static int i;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){
                i++;
            }
            Thread.interrupted();//标志位复位
            System.out.println("内部:"+Thread.currentThread().isInterrupted());
            System.out.println("Num:"+i);
        },"interruptDemo");

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        System.out.println(thread.isInterrupted());

        Thread thread02 = new Thread(()->{
            while(true){
                boolean ii = Thread.currentThread().isInterrupted();
                if(ii){
                    System.out.println("before : "+Thread.currentThread().getName()+" "+ii);
                    Thread.interrupted();//对线程进行复位，中断标志为false
                    System.out.println("after : "+Thread.currentThread().getName()+" "+Thread.currentThread().isInterrupted());
                }
            }
        },"Thread02");
        thread02.start();
        TimeUnit.SECONDS.sleep(1);
        thread02.interrupt();
    }
}
