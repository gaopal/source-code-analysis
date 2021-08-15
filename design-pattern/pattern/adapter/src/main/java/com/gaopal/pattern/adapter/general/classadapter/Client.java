package com.gaopal.pattern.adapter.general.classadapter;

public class Client {
  public static void main(String[] args) {
    ITarget adapter = new Adapter();
    int result = adapter.request();
    System.out.println(result);
  }
}
