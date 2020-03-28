package com.shadow.proxy.jdk.proxy;

public class Rose implements Human {
    @Override
    public String sing() {
        return "rose sing...";
    }

    @Override
    public void dance() {
        System.out.println("rose dance...");
    }

    @Override
    public String rap() {
        return "rose rap....";
    }

    @Override
    public void basketball() {
        System.out.println("rose basketball....");
    }
}
