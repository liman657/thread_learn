package com.learn.foundation;

/**
 * author:liman
 * createtime:2018/9/17
 * mobile:15528212893
 * email:657271181@qq.com
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread "+Thread.currentThread().getId()+" is running");
    }
}
