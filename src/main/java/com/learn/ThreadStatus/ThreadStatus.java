package com.learn.ThreadStatus;

import java.util.concurrent.TimeUnit;

/**
 * author:liman
 * createtime:2018/9/17
 * mobile:15528212893
 * email:657271181@qq.com
 * comment:
 *      线程的状态
 */
public class ThreadStatus {
    public static void main(String[] args) {
        //TIME-WAITING
        new Thread(()->{
            while(true){
                try{
                    TimeUnit.SECONDS.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"time_waiting").start();

        //WAITING
        new Thread(()->{
            while(true){
                synchronized (ThreadStatus.class){
                    try{
                        ThreadStatus.class.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        },"waiting").start();

        //线程在ThreadStatus加锁后，不会释放锁
        new Thread(new BlockedDemo(),"BlockDemo-01").start();
        new Thread(new BlockedDemo(),"BlockDemo-02").start();
    }

    static class BlockedDemo extends Thread{
        @Override
        public void run() {
            synchronized (BlockedDemo.class){
                while(true){
                    try{
                        TimeUnit.SECONDS.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
