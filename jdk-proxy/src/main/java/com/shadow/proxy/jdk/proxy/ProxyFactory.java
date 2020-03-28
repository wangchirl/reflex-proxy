package com.shadow.proxy.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类，必须实现  {@link InvocationHandler}
 */
public class ProxyFactory implements InvocationHandler {

    // 被代理的对象
    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    /**
     * 业务处理方法
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        preHandler();
        Object o = method.invoke(object, args);
        postHandler();
        return o;
    }

    /**
     * 这里是基于代理对象的接口生成的代理对象
     * 因此使用时必须强转转换成接口类型
     * @return
     */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }


    private void preHandler() {
        System.out.println("preHandler invoke...");
    }

    private void postHandler() {
        System.out.println("postHandler invoke...");
    }
}
