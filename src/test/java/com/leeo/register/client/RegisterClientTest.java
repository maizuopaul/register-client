package com.leeo.register.client;

public class RegisterClientTest {
    public static void main(String args[]) throws Exception{
        RegisterClient client = new RegisterClient();
        client.start();
        Thread.sleep(30*1000L);

        client.shutdown();

    }
}
