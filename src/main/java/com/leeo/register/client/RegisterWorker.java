package com.leeo.register.client;

import java.util.UUID;

/**
 * RegisterWorker 负责服务注册和发送心跳
 *
 */
public class RegisterWorker{

    //下面的常量都可以走配置形势
    private static final String SERVICE_NAME = "inventory_system_service";
    private static final String IP = "192.169.56.13";
    private static final int PORT  = 9000;
    private static final String HOST_NAME = "leeo";
    private static final long HEARTBEAT_INTERVA_MILLSECONDS = 5 *1000L;  //心跳间隔时长
    private String serviceInstanceId;


    private volatile boolean isRunning = true;

    //http请求 通信组件
    private RegisterServerSender sender;

    public RegisterWorker(){
        this.sender = new RegisterServerSender();
        this.serviceInstanceId = UUID.randomUUID().toString().replace("-","");
    }



    public void start(){
        try{
            RegisterThread registerThread = new RegisterThread();
            registerThread.start();
            registerThread.join();      //等待注册线程执行完毕

            HeartbeatThread heartbeatThread = new HeartbeatThread();
            heartbeatThread.start();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }


    private class RegisterThread extends Thread{
        @Override
        public void run() {
            register();
        }
    }

    private class HeartbeatThread extends Thread{
        @Override
        public void run() {
            while (isRunning){
                sender.heartbeat(SERVICE_NAME,serviceInstanceId);
                try {
                    Thread.sleep(HEARTBEAT_INTERVA_MILLSECONDS);
                } catch (InterruptedException e) {
                    System.out.println("发送心跳出错啦!");
                    e.printStackTrace();
                    return;
                }
            }
        }
    }


    /**
     * 请求注册服务
     */
    public RegisterResponse register(){

        //构造请求体
        RegisterClientRequest request = new RegisterClientRequest();
        request.setServiceName(SERVICE_NAME);
        request.setServiceInstanceId(serviceInstanceId);
        request.setHostname(HOST_NAME);
        request.setIp(IP);
        request.setPort(PORT);

        //TODO 发送请求 请求Register-server 进行注册

        RegisterResponse response = sender.sendRegister(request);
        response.setCode(RegisterResponse.SUCCESS);

        return response;
    }

    public void shutdown(){
        isRunning = false;
        System.out.println("服务被关闭了。。。");
    }

}
