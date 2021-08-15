package com.gaopal.pattern.adapter.general.interfaceadapter;

public class Client {
  public static void main(String[] args) {
    ITarget adapter =
        new Adapter(new Adaptee()) {
          @Override
          public int request1() {
            return adaptee.specificRequest() / 10;
          }
        };
    int result = adapter.request1();
    System.out.println(result);
  }
}
