package com.gaopal.java.c01_advance.jvm.c2_classloader;

public class T010_Parent {
  private static final T006_ClassLoader parent = new T006_ClassLoader();

  private static class MyLoader extends ClassLoader {
    public MyLoader() {
      super(parent);
    }
  }
}
