package com.leeo.register.client;

public class HeartbeatResponse {

    public static final String SUCCESS = "success";

    public static final String FAILURE = "failure";


    /**
     * 请求返回的状态码 200,300
     */
    private String status;

    /**
     * 返回状态 成功或失败
     */
    private String code;

    /**
     * 返回的消息内容 一般不使用
     */
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
