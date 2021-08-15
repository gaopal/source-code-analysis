package com.gaopal.java.c01_advance.jvm.c3_jmm;

public class TestSync {
  synchronized void m() {}

  void n() {
    synchronized (this) {
    }
  }

  public static void main(String[] args) {}
}
