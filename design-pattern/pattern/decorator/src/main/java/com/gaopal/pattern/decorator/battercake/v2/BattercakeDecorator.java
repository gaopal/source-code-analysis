package com.gaopal.pattern.decorator.battercake.v2;


public abstract class BattercakeDecorator extends Battercake {

  private Battercake battercake;

  public BattercakeDecorator(Battercake battercake) {
    this.battercake = battercake;
  }

  public abstract void doSomething();

  protected String getMsg() {
    return this.battercake.getMsg();
  }

  protected int getPrice() {
    return this.battercake.getPrice();
  }
}
