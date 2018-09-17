package com.learn.ThreadStop;

/**
 * author:liman
 * createtime:2018/9/17
 * mobile:15528212893
 * email:657271181@qq.com
 * comment:
 *      通过volatile字段中止线程
 */
public class VolatileInterruptDemo {

    //volatile字段让该变量对所有的线程可见
    private volatile static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            int i = 0;
            while(!stop){
                i++;
            }
            System.out.println(i);
        });
        thread.start();
        System.out.println("begin start thread");
        Thread.sleep(1000);
        stop = true;
    }

}
