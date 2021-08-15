package com.gaopal.java.c01_advance.jvm.c3_jmm;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class T05_ObjectLayout {
  public static void main(String[] args) throws InterruptedException {
    System.out.println("VM:");
    System.out.println(VM.current().details());
    System.out.println("Object:");
    System.out.println(ClassLayout.parseClass(Object.class).toPrintable());
    System.out.println("new Object:");
    System.out.println(ClassLayout.parseInstance(new Object()).toPrintable());

    // 空数组
    System.out.println("byte[]:");
    System.out.println(ClassLayout.parseClass(byte[].class).toPrintable());
    // 字符串
    System.out.println("String www.baidu.com:");
    System.out.println(ClassLayout.parseInstance("www.baidu.com".getBytes()).toPrintable());

    // new 一个对象
    TestObject testObject = new TestObject();
    // 输出 testObject对象 的布局
    System.out.println("testObject:");
    System.out.println(ClassLayout.parseInstance(testObject).toPrintable());
  }
}

// 对象类
class TestObject {
  private boolean myboolean = true;
}
