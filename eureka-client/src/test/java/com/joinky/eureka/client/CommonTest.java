package com.joinky.eureka.client;

public class CommonTest {
    public static void main(String[] args) {
        String status = "停";
        System.out.println(status.contains("stop")  || status.contains("停") ? "停止" : "启动");
    }
}
