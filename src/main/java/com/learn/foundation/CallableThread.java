package com.learn.foundation;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * author:liman
 * createtime:2018/9/17
 * mobile:15528212893
 * email:657271181@qq.com
 * comment:
 *      通过FutureTask包装器来创建Thread线程
 */
public class CallableThread implements Callable<String> {
    public String call() throws Exception {
        int a = 1;
        int b = 2;
        System.out.println(a+b);

        /**
         * 如果处理事件过长，客户端会阻塞
         * TimeUnit.SECONDS.sleep(20);
         */
        return "执行结果："+(a+b);
    }
}
