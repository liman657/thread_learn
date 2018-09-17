package com.learn.foundation;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * author:liman
 * createtime:2018/9/17
 * mobile:15528212893
 * email:657271181@qq.com
 */
public class ThreadDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread thread01= new MyThread();
        MyThread thread02 = new MyThread();
        thread01.start();
        thread02.start();

        MyRunnable runnable01 = new MyRunnable();
        MyRunnable runnable02 = new MyRunnable();

        //Runnable接口，需要通过Thread包装一下
        Thread RunThread01 = new Thread(runnable01);
        Thread RunThread02 = new Thread(runnable02);
        RunThread01.start();
        RunThread02.start();

        //获得Callable接口的返回结果
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        CallableThread callableThread = new CallableThread();
        Future<String> future = executorService.submit(callableThread);

        //客户端真正阻塞在这里，获取线程返回数据的时候，如果线程没有将数据准备好，这里会阻塞。
        System.out.println(future.get());
        executorService.shutdown();
    }

}
