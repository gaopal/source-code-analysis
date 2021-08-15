/**
 * synchronized�ؼ��� ��ĳ���������
 *
 * @author mashibing
 */
package com.gaopal.java.c01_advance.juc.c_001;

public class T {

  private int count = 10;
  private final Object o = new Object();

  public void m() {
    synchronized (o) { // �κ��߳�Ҫִ������Ĵ��룬�������õ�o����
      count--;
      System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
  }
}
