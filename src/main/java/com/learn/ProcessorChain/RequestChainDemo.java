package com.learn.ProcessorChain;

/**
 * author:liman
 * createtime:2018/9/17
 * mobile:15528212893
 * email:657271181@qq.com
 * comment:
 *      链式处理任务
 */
public class RequestChainDemo {

    PrintProcessor printProcessor;

    protected RequestChainDemo(){
        SaveProcessor saveProcessor =new SaveProcessor();
        saveProcessor.start();

        printProcessor = new PrintProcessor(saveProcessor);
        printProcessor.start();
    }

    private void doTest(Request request){
        printProcessor.processRequest(request);
    }

    public static void main(String[] args) {
        Request request = new Request();
        request.setName("Liman");
        new RequestChainDemo().doTest(request);
    }
}
