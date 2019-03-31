package com.leeo.register.client;

import java.io.Serializable;

/**
 * 注册请求类
 */
public class RegisterClientRequest  implements Serializable {

    /**
     * 服务id 用于标识不同服务
     */
    private String serviceInstanceId;

    /**
     * 服务器ip
     */
    private String ip;

    /**
     * 服务端口号
     */
    private int port;

    /**
     * 服务的主机名
     */
    private String hostname;


    public String getServiceInstanceId() {
        return serviceInstanceId;
    }

    public void setServiceInstanceId(String serviceInstanceId) {
        this.serviceInstanceId = serviceInstanceId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    @Override
    public String toString() {
        return "RegisterClientRequest{" +
                "serviceInstanceId='" + serviceInstanceId + '\'' +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", hostname='" + hostname + '\'' +
                '}';
    }
}
