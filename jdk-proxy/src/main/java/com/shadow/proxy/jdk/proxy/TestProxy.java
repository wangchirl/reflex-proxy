package com.shadow.proxy.jdk.proxy;


import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestProxy {

    public static void main(String[] args) throws IOException {
        // JDK动态代理的使用
        Jack jack = new Jack();
        ProxyFactory factory = new ProxyFactory();
        factory.setObject(jack);
        Human instance = (Human) factory.getProxyInstance();
        instance.dance();

        System.out.println("==================");
        Rose rose = new Rose();
        factory.setObject(rose);
        Human instance1 = (Human) factory.getProxyInstance();
        instance1.dance();

        System.out.println("==================");

        byte[] bytes = ProxyGenerator.generateProxyClass(
                "Human$Proxy", new Class[]{Human.class}
        );

        String fileName = System.getProperty("user.dir")+ "/jdk-proxy/target/Human$Proxy.class";
        File file = new File(fileName);
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(bytes);
        outputStream.close();


    }
}
