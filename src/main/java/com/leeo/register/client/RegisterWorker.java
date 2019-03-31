package com.leeo.register.client;

import java.util.UUID;

/**
 * RegisterWorker 负责服务注册和发送心跳
 *
 */
public class RegisterWorker extends Thread{

    //下面的常量都可以走配置形势
    private static final String SERVICE_NAME = "inventory_system_service";
    private static final String IP = "192.169.56.13";
    private static final int PORT  = 9000;
    private static final String HOST_NAME = "leeo";
    private static final long HEARTBEAT_INTERVA_MILLSL = 5 *1000L;  //心跳间隔时长



    @Override
    public void run() {
        register();
    }

    /**
     * 请求注册服务
     */
    public void register(){
        //构造请求体
        RegisterClientRequest request = new RegisterClientRequest();
        request.setServiceInstanceId(UUID.randomUUID().toString().replace("-",""));
        request.setHostname(HOST_NAME);
        request.setIp(IP);
        request.setPort(PORT);

        //TODO 发送请求 请求Register-server 进行注册

        RegisterServerSender sender = new RegisterServerSender();
        RegisterResponse response = sender.sendRegister(request);
        if (RegisterResponse.SUCCESS.equals(response.getCode())){

            while (true){
                heartbeart(SERVICE_NAME,request.getServiceInstanceId());
                try {
                    Thread.sleep(HEARTBEAT_INTERVA_MILLSL);
                } catch (InterruptedException e) {
                    System.out.println("发送心跳出错啦!");
                    e.printStackTrace();
                    return;
                }
            }
        }


    }


    /**
     * 请求心跳
     */
    private void heartbeart(String serviceName,String serviceInstanceId){

        //TODO 发送心跳请求 http请求register-server进行心跳并返回心跳结果
        System.out.println("发送心跳:" + serviceName + "->" + serviceInstanceId);
    }

}
