package com.learn.ProcessorChain;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * author:liman
 * createtime:2018/9/17
 * mobile:15528212893
 * email:657271181@qq.com
 */
public class PrintProcessor extends Thread implements RequestProcessor {

    /**
     * 业务逻辑链
     * 这里用阻塞队列的原因，就是在没有任务的时候，take操作会阻塞，如果有元素了，take操作会被唤醒
     */
    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<Request>();

    //下一个任务
    private final RequestProcessor nextProcessor;

    public PrintProcessor(RequestProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void run() {
        while(true){
            try{
                //队列中没有元素会在这里阻塞
                Request request = requests.take();
                //这里是处理当前任务
                System.out.println("begin print request data : "+request.getName());

                //处理下一个任务
                nextProcessor.processRequest(request);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    //处理请求
    public void processRequest(Request request) {
        //先将请求放到任务链中，后面统一处理
        requests.add(request);
    }
}
