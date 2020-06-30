package com.wonjin.effective.constructor.singleton;

public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() { }

    public static Elvis getInstance() { return INSTANCE; }
}