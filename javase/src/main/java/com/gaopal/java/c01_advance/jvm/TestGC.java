package com.gaopal.java.c01_advance.jvm;

public class TestGC {
  public static void main(String[] args) {
    for (; ; ) {
      new Object();
    }
  }
}
