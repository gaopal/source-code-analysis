package com.gaopal.java.c01_advance.jvm.c2_classloader;

public class T011_ClassReloading1 {
  public static void main(String[] args) throws Exception {
    T006_ClassLoader classLoader = new T006_ClassLoader();
    Class clazz = classLoader.loadClass("com.gaopal.java.c01_advance.jvm.Hello");

    classLoader = null;
    System.out.println(clazz.hashCode());

    classLoader = null;

    classLoader = new T006_ClassLoader();
    Class clazz1 = classLoader.loadClass("com.gaopal.java.c01_advance.jvm.Hello");
    System.out.println(clazz1.hashCode());

    System.out.println(clazz == clazz1);
  }
}
