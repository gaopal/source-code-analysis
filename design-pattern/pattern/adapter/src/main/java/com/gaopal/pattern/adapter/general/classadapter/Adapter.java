package com.gaopal.pattern.adapter.general.classadapter;

public class Adapter extends Adaptee implements ITarget {
  public int request() {
    return super.specificRequest() / 10;
  }
}
