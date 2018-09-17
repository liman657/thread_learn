package com.learn.ProcessorChain;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * author:liman
 * createtime:2018/9/17
 * mobile:15528212893
 * email:657271181@qq.com
 */
public class SaveProcessor extends Thread implements RequestProcessor {

    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<Request>();

    public void processRequest(Request request) {
        requests.add(request);
    }

    @Override
    public void run() {
        while(true){
            try{
                Request request = requests.take();
                System.out.println("begin save request info :"+request);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
