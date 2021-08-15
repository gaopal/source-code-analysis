package com.gaopal.pattern.adapter.general.objectadapter;

public class Adapter implements ITarget {
  private Adaptee adaptee;

  public Adapter(Adaptee adaptee) {
    this.adaptee = adaptee;
  }

  public int request() {
    return adaptee.specificRequest() / 10;
  }
}
