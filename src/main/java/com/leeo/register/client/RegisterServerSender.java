package com.leeo.register.client;

import java.io.Serializable;


/**
 * 注册中心 通信组件
 * 对客户端的服务进行注册，heartbeat操作
 */
public class RegisterServerSender implements Serializable {


    /**
     * 发送注册请求
     * @param request
     * @return 注册请求后的结果
     */
    public RegisterResponse sendRegister(RegisterClientRequest request){

        //TODO http 请求register-server 模拟返回结果

        RegisterResponse response = new RegisterResponse();
        response.setCode(RegisterResponse.SUCCESS);

        System.out.println("注册成功:[" + request + "]");
        return response;
    }

    public HeartbeatResponse heartbeat(String serviceName,String serviceInstanceId){

        //TODO http 请求register-server 模拟返回结果
        HeartbeatResponse response = new HeartbeatResponse();
        System.out.println("发送心跳:serviceName="+serviceName + ";serviceInstanceId="+serviceInstanceId);
        response.setCode(HeartbeatResponse.SUCCESS);
        return response;
    }
}
