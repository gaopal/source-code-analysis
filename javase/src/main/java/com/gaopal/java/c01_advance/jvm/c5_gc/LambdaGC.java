package com.gaopal.java.c01_advance.jvm.c5_gc;

public class LambdaGC {
  public static void main(String[] args) {
    for (; ; ) {
      I i = C::n;
    }
  }

  public interface I {
    void m();
  }

  public static class C {
    static void n() {
      System.out.println("hello");
    }
  }
}
