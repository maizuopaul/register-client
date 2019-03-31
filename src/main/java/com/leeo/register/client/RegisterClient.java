package com.leeo.register.client;

public class RegisterClient{




    public RegisterClient(){}


    /**
     * 启动
     */
    public void start(){
        new RegisterWorker().start();
    }



}
