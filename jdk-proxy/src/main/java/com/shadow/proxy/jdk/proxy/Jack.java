package com.shadow.proxy.jdk.proxy;

public class Jack implements Human {
    @Override
    public String sing() {
        return "Hello Jack sing";
    }

    @Override
    public void dance() {
        System.out.println("Jack dancer");
    }

    @Override
    public String rap() {
        return "Jack 这个大碗，是那么的园，你很喜欢，我也心愿";
    }

    @Override
    public void basketball() {
        System.out.println("Jack play the ball");
    }
}
