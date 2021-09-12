package com.zhangyi.strategy;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/9/7 23:24
 */
public class Test {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("Local HostAddress: " + addr.getHostAddress());
        String hostname = addr.getHostName();
        System.out.println("Local host name: " + hostname);
        InetAddress localHost = Inet4Address.getLocalHost();
        System.out.println(localHost.getHostAddress());
    }
}
