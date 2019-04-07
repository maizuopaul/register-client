package com.leeo.register.client;

public class RegisterClient{


    private RegisterWorker registerWorker;


    public RegisterClient(){
        registerWorker = new RegisterWorker();
    }


    /**
     * 启动
     */
    public void start(){
        registerWorker.start();
    }

    public void shutdown(){
        registerWorker.shutdown();
    }


}
