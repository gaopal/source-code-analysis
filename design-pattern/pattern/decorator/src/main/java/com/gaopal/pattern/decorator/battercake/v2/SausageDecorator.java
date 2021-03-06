package com.gaopal.pattern.decorator.battercake.v2;


public class SausageDecorator extends BattercakeDecorator {
  public SausageDecorator(Battercake battercake) {
    super(battercake);
  }

  public void doSomething() {}

  @Override
  protected String getMsg() {
    return super.getMsg() + "1根香肠";
  }

  @Override
  protected int getPrice() {
    return super.getPrice() + 2;
  }
}
