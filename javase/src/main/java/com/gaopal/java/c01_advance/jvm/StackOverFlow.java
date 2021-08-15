package com.gaopal.java.c01_advance.jvm;

public class StackOverFlow {
    public static void main(String[] args) {
        m();
    }

    static void m() {
        m();
    }
}
